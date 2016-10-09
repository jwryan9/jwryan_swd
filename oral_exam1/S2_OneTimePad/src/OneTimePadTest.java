import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class to demonstrate the capabilities of OneTimePad
 */
public class OneTimePadTest {

    /**
     * Main method of oneTimePadTest class
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String message, encrypted;
        int numKeys;
        int[] keyArr;

        Scanner kb = new Scanner(System.in);
        boolean valid;

        // While user message string contains a number or symbol re-enter
        do {
            System.out.println("Enter message (No numbers or symbols): ");
            message = kb.nextLine();
            message = message.toUpperCase();

            // Validate with regular expression, only allow spaces and letters
            valid = message.matches("[ A-Z]+");
        } while (!valid);

        Encryptor encryptor = new Encryptor(message);

        System.out.print("Encryption keys: ");
        for (int key : encryptor.getKeys()) {
            System.out.print(" " + key);
        }
        System.out.println("\nEncrypted message: " + encryptor.getEncryptedText());

        do {
            System.out.println("\nEnter text to decrypt (No numbers or symbols): ");
            encrypted = kb.nextLine();
            encrypted = encrypted.toUpperCase();

            // Validate with regular expression, only allow spaces and letters
            valid = encrypted.matches("[ A-Z]+");
        } while (!valid);

        numKeys = encryptor.messageLength(encrypted);
        keyArr = new int[numKeys];

        System.out.println("Enter encryption keys (Integers 0 - 25): ");

        for (int i = 0; i < numKeys; i++) {
            System.out.print((i + 1) + ": ");

            // If user enters an invalid key, prompt for valid key
            do {
                try {
                    keyArr[i] = kb.nextInt();
                    valid = true;
                } catch (InputMismatchException ex) {
                    keyArr[i] = -1;
                    kb.nextLine();
                }
                if(keyArr[i] < 0 || keyArr[i] > 25) {
                    System.out.println("Invalid key, please enter integer between 0 and 25.");
                    valid = false;
                }
            } while (!valid);
        }

        Decryptor decryptor = new Decryptor(encrypted, keyArr);
        System.out.println(decryptor.getDecryptedText());
    }
}