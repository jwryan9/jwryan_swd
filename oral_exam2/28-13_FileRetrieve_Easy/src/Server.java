import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Server class for file retrieval
 */
public class Server extends JFrame {
    private JTextArea displayArea;
    private ObjectOutputStream output; // Output to client
    private ObjectInputStream input; // Input from client
    private ServerSocket server; // Socket for server
    private Socket connection; // Connection to client
    public Scanner fileInput;
    private int counter = 1; // To count number of connections

    /**
     * Constructor initializes server and sets up GUI
     */
    public Server() {
        super("28-13 Server");

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150);
        setVisible(true);
    }

    /**
     * Makes connections to clients and processes messages
     */
    public void runServer() {
        try {
            server = new ServerSocket(12345, 100);

            while(true) {
                try {
                    waitForConnection();
                    getStreams();
                    processConnection();
                } catch (EOFException e) {
                    displayMessasge("\nConnection terminated by server");
                } finally {
                    closeConnection();
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for connection from client
     *
     * @throws IOException thrown if I/O error occurs when waiting for connection
     */
    private void waitForConnection() throws IOException {
        displayMessasge("Wait for connection\n");
        connection = server.accept();
        displayMessasge("Connection " + counter + " received from: " + connection.getInetAddress().getHostName());
    }

    /**
     * Setup streams for sending and receiving data
     *
     * @throws IOException thrown when stream not opened correctly
     */
    private void getStreams() throws IOException {
        // Setup input
        input = new ObjectInputStream(connection.getInputStream());

        // Setup output
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
    }

    /**
     * Processes connection with client for reading messages
     *
     * @throws IOException thrown when readObject fails
     */
    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message);

        // Listen for client messages while client has not terminated connection
        do {
            try {
                message = (String) input.readObject();
                displayMessasge("\n" + message);
                openFile(message);
            } catch (ClassNotFoundException e) {
                displayMessasge("\nRecieved unknown object type.");
            }
        } while(!message.equals("CLIENT>>> TERMINATE"));
    }

    /**
     * Closes streams and socket to end connection with client
     */
    private void closeConnection() {
        displayMessasge("\nTerminating connection\n");

        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send message to client
     *
     * @param message string to send to client
     */
    private void sendData(String message) {
        try
        {
            output.writeObject("SERVER>>> " + message);
            output.flush();
            displayMessasge("\nSERVER>>> " + message);
        } catch (IOException e) {
            displayArea.append("\nError writing object.");
        }
    }

    /**
     * Manipulates display area in the event-dispatch thread to display message
     *
     * @param messageToDisplay
     */
    private void displayMessasge(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                () -> displayArea.append(messageToDisplay)
        );
    }

    /**
     * Open file to send contents to client
     *
     * @param filepath path to file to be opened
     */
    private void openFile(String filepath) {
        try {
            fileInput = new Scanner(Paths.get(filepath));
        } catch (IOException e) {
            displayMessasge("\nError opening file.");
            sendData("Error opening file.");

            return;
        }

        readFile(fileInput);
    }

    /**
     * Read file line by line and transmit data
     *
     * @param fileInput file scanner to read
     */
    private void readFile(Scanner fileInput) {
        try {
            while(fileInput.hasNext()) {
                sendData(fileInput.nextLine());
            }
        } catch (NoSuchElementException e) {
            displayMessasge("File improperly formatted.");
        } catch (IllegalStateException e) {
            displayMessasge("Errorreading from file.");
        } finally {
            closeFile(fileInput);
        }
    }

    /**
     * Close file scanner
     *
     * @param fileInput file scanner to close
     */
    private void closeFile(Scanner fileInput) {
        if(fileInput != null) {
            fileInput.close();
        }
    }

}
