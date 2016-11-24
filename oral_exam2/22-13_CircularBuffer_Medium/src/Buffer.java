/**
 * Buffer interface specifies methods called by Producer and Consumer
 *
 * @author Jason Ryan
 */
public interface
Buffer {
    // place int value into Buffer
    void blockingPut(int value) throws InterruptedException;

    // obtain int value from Buffer
    int blockingGet() throws InterruptedException;
} // end interface Buffer