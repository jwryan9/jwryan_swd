import javax.swing.*;

/**
 * Tester class for running file retrieve server
 */
public class ServerTest {
    /**
     * Main method, runs server program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Server application = new Server();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer();
    }
}
