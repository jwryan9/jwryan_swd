import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jasonryan on 9/1/16.
 */
public class Encryptor {

    private final int MAX_KEY = 26;
    private final int ALPHA_LENGTH = 26;

    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private String encryptedText = "";
    private int[] keys;

    public Encryptor(String message) {
        keys = generateKeys(messageLength(message));
        encrypt(message.toUpperCase(), keys);
    }

    public String getEncryptedText() {
        return encryptedText;
    }

    public int[] getKeys() {
        return keys;
    }

    // Method gets length of message without counting spaces
    private int messageLength(String message) {
        return message.replace(" ", "").length();
    }

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

    private int[] generateKeys(int num) {
        int[] rand = new int[num];
        Random randGen = new Random();

        for(int i=0; i < num; i++) {
            rand[i] = randGen.nextInt(MAX_KEY);
        }

        return rand;
    }


}
