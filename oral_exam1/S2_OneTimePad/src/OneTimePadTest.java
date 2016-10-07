import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by jwryan on 8/31/16.
 */
public class OneTimePadTest {

    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args)
    {
        String message, encrypted, keyText;
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
        } while(!valid);

        Encryptor encryptor = new Encryptor(message);

        System.out.print("Encryption keys: ");
        for(int key : encryptor.getKeys()) {
            System.out.print(" " + key);
        }
        System.out.println("\nEncrypted message: " + encryptor.getEncryptedText());

        do {
            System.out.println("\nEnter text to decrypt (No numbers or symbols): ");
            encrypted = kb.nextLine();
            encrypted = encrypted.toUpperCase();

            // Validate with regular expression, only allow spaces and letters
            valid = encrypted.matches("[ A-Z]+");
        } while(!valid);

        numKeys = encryptor.messageLength(encrypted);
        keyArr = new int[numKeys];

        System.out.println("Enter encryption keys (Integers): ");

        for(int i = 0; i < numKeys; i++) {
            System.out.print((i + 1) + ": ");
            try {
                keyArr[i] = kb.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid key. Decryption failed.");
                return;
            }
        }

        Decryptor decryptor = new Decryptor(encrypted, keyArr);
        System.out.println(decryptor.getDecryptedText());
    }

}
