import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class for encrypting user message.
 *
 * @author Jason Ryan
 */
public class Encryptor {

    private final int MAX_KEY = 26;
    private final int ALPHA_LENGTH = 26;

    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private String encryptedText = "";
    private int[] keys;

    /**
     * Constructor, randomly generates keys and encryptes message
     *
     * @param message String message to be encrypted
     */
    public Encryptor(String message) {
        keys = generateKeys(messageLength(message));
        encrypt(message.toUpperCase(), keys);
    }

    /**
     * Getter method for encryptedText
     *
     * @return String encryptedText
     */
    public String getEncryptedText() {
        return encryptedText;
    }

    /**
     * Getter for keys
     *
     * @return int[] keys
     */
    public int[] getKeys() {
        return keys;
    }

    /**
     * Gets length of message minus spaces
     *
     * @param message String messagee to get length
     * @return int length of string witout spaces
     */
    public int messageLength(String message) {
        return message.replace(" ", "").length();
    }

    /**
     * Encrypts a message using provided keys
     *
     * @param message String message to be encrypted
     * @param keys int[] keys to use for encryption
     */
    private void encrypt(String message, int[] keys) {
        char alpha, let, encryptLet;
        int key;
        int keyIt = 0;

        char[] messageChars = message.toCharArray();

        for(int i = 0; i < message.length(); i++) {
            key = keys[keyIt];
            let = messageChars[i];
            encryptLet = ' ';

            if(let != ' ') {
                for(int j = 0; j < alphabet.length; j++) {
                    alpha = alphabet[j];

                    if(let == alpha)
                        // Use mod function to wrap to start of array when alphabet end is reached
                        encryptLet = alphabet[(j + key) % ALPHA_LENGTH];
                }

                // Increment key iterator only on non-space character
                keyIt++;
            }

            // Build String with encrypted letters
            encryptedText += encryptLet;
        }
    }

    /**
     * Randomly generates integers 0 - 25
     *
     * @param num int number of random integers to generate
     * @return int[] of randomly generated integers 0 - 25
     */
    private int[] generateKeys(int num) {
        int[] rand = new int[num];
        Random randGen = new Random();

        for(int i=0; i < num; i++) {
            rand[i] = randGen.nextInt(MAX_KEY);
        }

        return rand;
    }


}
