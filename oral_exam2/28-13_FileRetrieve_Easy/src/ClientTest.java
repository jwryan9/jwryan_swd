import javax.swing.*;

/**
 * Tester class for running file retrieve client
 *
 * @author Jason Ryan
 */
public class ClientTest {

    /**
     * Main method, runs client program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Client application;

        if(args.length == 0) {
            application = new Client("127.0.0.1");
        } else {
            application = new Client(args[0]);
        }

        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.runClient();
    }
}
