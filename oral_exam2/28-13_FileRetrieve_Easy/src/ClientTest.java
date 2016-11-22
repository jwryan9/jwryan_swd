import javax.swing.*;

/**
 * Created by jasonryan on 11/21/16.
 */
public class ClientTest {
    public static void main(String[] args) {
        Client application;

        if(args.length == 0) {
            application = new Client("123.0.0.1");
        } else {
            application = new Client(args[0]);
        }

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient();
    }
}
