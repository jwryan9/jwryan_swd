import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by jasonryan on 9/1/16.
 */
public class Encryptor {

    private char[] messageChars;
    private char[] encryptedChars;
    private String encryptedText = "";
    private final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) {
        String message;
        int key = 0;
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter message.");
        message = kb.nextLine();
        message.toUpperCase();

        System.out.println("Enter positive integer key.");
        do {
            try {
                key = kb.nextInt();

                if(key <= 0) {
                    System.out.println("Key must be greater than zero. Please enter valid key.");
                }

            } catch (InputMismatchException ex) {
                System.out.println("Invalid key entered. Please enter valid key.");
                kb.nextLine();
            }
        } while (key <= 0);

        new Encryptor(message, key);
    }

    public Encryptor(String message, int key) {
        encryptedText = encrypt(message.toUpperCase(), key);
        System.out.println(message);
        System.out.println(encryptedText);
    }

    private String encrypt(String message, int key) {
        char let;
        char encryptLet;
        encryptedChars = new char[message.length()];

        messageChars = message.toCharArray();

        for(int i = 0; i < message.length(); i++) {
            let = messageChars[i];
            encryptLet = ' ';

            if(let != ' ') {
                for(int j = 0; j < alphabet.length; j++) {
                    char alpha = alphabet[j];

                    if(let == alpha)
                        encryptLet = alphabet[(j + key) % 26];
                }
            }

            encryptedChars[i] = encryptLet;
            encryptedText += encryptLet;
        }

        return encryptedText;
    }


}
