import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Client class for file retrieval
 */
public class Client extends JFrame {
    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String serverMessage = "";
    private String fileServer;
    private Socket client;

    /**
     * Constructor initializes client and sets up GUI
     *
     * @param host host addres
     */
    public Client(String host) {
        super("28-13 Client");

        fileServer = host;

        enterField = new JTextField();
        enterField.setEditable(false);
        enterField.addActionListener(
                e -> {
                    System.out.println(e.getActionCommand());
                    sendData(e.getActionCommand());
                    enterField.setText("");
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150);
        setVisible(true);
    }

    /**
     * Connects to server and processes server messages
     */
    public void runClient() {
        // Connect to server, get streams, process connection
        try {
            connectToServer();
            getStreams();
            processConnection();
        } catch (EOFException eofException) {
            displayMessage("\nClient terminated connection.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    /**
     * Makes connection to server
     *
     * @throws IOException thrown when server connection fails
     */
    private void connectToServer() throws IOException {
        displayMessage("Attempting connection.\n");

        // Socket to make connection to server
        client = new Socket(InetAddress.getByName(fileServer), 12345);
        displayMessage("Connected to: " + client.getInetAddress().getHostName());
    }

    /**
     * Setup streams for sending and receiving data
     *
     * @throws IOException thrown when stream not opened correctly
     */
    private void getStreams() throws IOException {
        // set up output stream
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();

        // set up input stream
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams.\n");
    }

    /**
     * Processes connection with server for reading messages
     *
     * @throws IOException thrown when readObject fails
     */
    private void processConnection() throws IOException {
        // enable field so client can send file path
        setTextFieldEditable(true);

        // Process server messages
        do {
            try {
                // Read and display message
                serverMessage = (String) input.readObject();
                displayMessage("\n" + serverMessage);
            } catch (ClassNotFoundException e) {
                displayMessage("\nUnknown object type received.");
            }
        } while(!serverMessage.equals("SERVER>>> TERMINATE"));
    }

    /**
     * Closes streams and socket to end connection with server
     */
    private void closeConnection() {
        displayMessage("\nClosing connection.");
        setTextFieldEditable(false);

        try {
            // Close streams
            output.close();
            input.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send filepath to server
     *
     * @param filepath path of file to be retrieved by server
     */
    private void sendData(String filepath) {
        try {
            // Send object to server
            output.writeObject(filepath);
            output.flush();
            displayMessage("\nCLIENT>> " + filepath);
        } catch (IOException e) {
            displayArea.append("\nError writing object.");
        }
    }

    /**
     * Manipulates displayArea in the event-dispatch thread
     * to display file contents.
     *
     * @param messageToDisplay message sent by the server to be displayed
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                () -> displayArea.append(messageToDisplay)
        );
    }

    /**
     * Manipulates enterField in the event-dispatch thread
     *
     * @param editable boolean value for allowing user to enter text
     */
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                () -> enterField.setEditable(editable)
        );
    }

}
