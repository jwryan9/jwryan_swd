import java.security.SecureRandom;

/**
 * Producer with a run method that inserts the values 1 to 10 in shared buffer
 *
 * @author Jason Ryan
 */
public class Producer implements Runnable {
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation; // reference to shared object

    /**
     * Constructor
     *
     * @param sharedLocation Buffer where shared values are stored
     */
    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    /**
     * Store values from 1 to 10 in sharedLocation
     */
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            try // sleep 0 to 3 seconds, then place value in Buffer
            {
                Thread.sleep(generator.nextInt(3000)); // random sleep
                sharedLocation.blockingPut(count); // set value in buffer
                sum += count; // increment sum of values
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf(
                "Producer done producing%nTerminating Producer%n");
    }
}