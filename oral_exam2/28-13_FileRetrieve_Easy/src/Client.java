import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by jasonryan on 11/21/16.
 */
public class Client extends JFrame {
    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message;
    private String fileServer;
    private Socket client;

    public Client(String host) {
        super("28-13 Client");

        fileServer = host;

        enterField = new JTextField();
        enterField.addActionListener(
                e -> {
                    sendData(e.getActionCommand());
                    enterField.setText("");
                }
        );
    }

    public void runClient() {

    }
}
