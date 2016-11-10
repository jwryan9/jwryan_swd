import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Using locks and conditions to synchronize access to a shared three-element bounded buffer.
 *
 * @author Jason Ryan
 */
public class CircularBuffer implements Buffer {

    // Lock to control synchronization with this buffer
    private final Lock accessLock = new ReentrantLock();

    // Conditions to control reading and writing
    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();

    private final int[] buffer = {-1, -1, -1}; // shared buffer

    private int occupiedCells = 0; // count number of buffers used
    private int writeIndex = 0; // index of next element to write to
    private int readIndex = 0; // index of next element to read

    /**
     * Method for placing value into buffer
     *
     * @param value value to be insert in buffer
     * @throws InterruptedException thrown when thread is occupied and is interrupted
     */
    public void blockingPut(int value) throws InterruptedException {

        accessLock.lock(); // Lock this object

        try {
            // wait until buffer has space available, then write value;
            // while no empty locations, place thread in waiting state
            while (occupiedCells == buffer.length) {
                System.out.printf("Buffer is full. Producer waits.%n");
                canWrite.await(); // wait until a buffer cell is free
            }

            buffer[writeIndex] = value; // set new buffer value

            // update circular write index
            writeIndex = (writeIndex + 1) % buffer.length;

            ++occupiedCells; // one more buffer cell is full
            displayState("Producer writes " + value);

            // Signal any threads waiting to read from buffer
            canRead.signalAll();

        } finally {
            accessLock.unlock(); // unlock this object
        }
    }

    /**
     * Method for returning value from buffer
     *
     * @return value from buffer
     * @throws InterruptedException thrown when thread is occupied and is interrupted
     */
    public int blockingGet() throws InterruptedException {

        int readValue = -1; // Initialize value read from buffer
        accessLock.lock(); // Lock this object

        try {
            // wait until buffer has data, then read value;
            // while no data to read, place thread in waiting state
            while (occupiedCells == 0) {
                System.out.printf("Buffer is empty. Consumer waits.%n");
                canRead.await(); // wait until a buffer cell is filled
            }

            readValue = buffer[readIndex]; // read value from buffer

            // update circular read index
            readIndex = (readIndex + 1) % buffer.length;

            --occupiedCells; // one fewer buffer cells are occupied
            displayState("Consumer reads " + readValue);

            // Signal any threads waiting to write to the buffer
            canWrite.signalAll();

        } finally {
            accessLock.unlock(); // unlock this object
        }

        return readValue;
    }

    /**
     * Method to display current operation and buffer state
     *
     * @param operation action performed on buffer
     */
    public void displayState(String operation) {

        try {
            accessLock.lock(); // Lock this object

            // output operation and number of occupied buffer cells
            System.out.printf("%s%s%d)%n%s", operation,
                    " (buffer cells occupied: ", occupiedCells, "buffer cells:  ");

            for (int value : buffer)
                System.out.printf(" %2d  ", value); // output values in buffer

            System.out.printf("%n               ");

            for (int aBuffer : buffer) System.out.print("---- ");

            System.out.printf("%n               ");

            for (int i = 0; i < buffer.length; i++) {
                if (i == writeIndex && i == readIndex)
                    System.out.print(" WR"); // both write and read index
                else if (i == writeIndex)
                    System.out.print(" W   "); // just write index
                else if (i == readIndex)
                    System.out.print("  R  "); // just read index
                else
                    System.out.print("     "); // neither index
            }
        } finally {
            accessLock.unlock(); // Unlock this object
        }

        System.out.printf("%n%n");
    }
} // end class CircularBuffer