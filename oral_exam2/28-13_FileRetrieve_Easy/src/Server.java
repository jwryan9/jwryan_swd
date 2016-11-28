import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class for file retrieval
 *
 * @author Jason Ryan
 */
public class Server extends JFrame {
    private JTextArea displayArea;
    private ObjectOutputStream output; // Output to client
    private ObjectInputStream input; // Input from client
    private ServerSocket server; // Socket for server
    private Socket connection; // Connection to client
    private BufferedReader fileReader; // Buffered reader for reading file
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

            // Loop while connections made
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
                displayMessasge("\nReceived unknown object type.");
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
     * @param messageToDisplay message to be written to screen
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
        String error = "Error opening file: " + filepath + ".";
        try {
            fileReader = new BufferedReader(new FileReader(filepath));
            readFile(fileReader);
        } catch (IOException e) {
            displayMessasge("\n" + error);
            sendData(error);
            e.printStackTrace();
        }
    }

    /**
     * Read file line by line and transmit data
     *
     * @param fileReader file to read
     */
    private void readFile(BufferedReader fileReader) {
        String line;
        String error = "\nError reading file.";
        try {
            while((line = fileReader.readLine()) != null) {
                sendData(line);
            }
        } catch (IOException e) {
            displayMessasge(error);
            sendData(error);
        } finally {
            closeFile(fileReader);
        }
    }

    /**
     * Close file scanner
     *
     * @param fileReader file Buffered Reader to close
     */
    private void closeFile(BufferedReader fileReader) {
        final String error = "\nError closing file.";
        try {
            fileReader.close();
        } catch (IOException e) {
            displayMessasge(error);
            sendData(error);
        }
    }

}
