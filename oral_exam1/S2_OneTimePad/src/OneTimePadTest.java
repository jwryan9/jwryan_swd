import java.util.Scanner;

/**
 * Created by jwryan on 8/31/16.
 */
public class OneTimePadTest {

    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args)
    {
        String message;
        Scanner kb = new Scanner(System.in);
        boolean valid;

        // While user message string contains a number or symbol re-enter
        do {
            System.out.println("Enter message (No numbers or symbols).");
            message = kb.nextLine();
            message = message.toUpperCase();

            // Validate with regular expression, only allow spaces and
            valid = message.matches("[ A-Z]+");
        } while(!valid);

        Encryptor encryptor = new Encryptor(message);

        System.out.print("Encryption keys: ");
        for(int key : encryptor.getKeys()) {
            System.out.print(" " + key);
        }
        System.out.println("\nEncrypted message: " + encryptor.getEncryptedText());
    }

}
