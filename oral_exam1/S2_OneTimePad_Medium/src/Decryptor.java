/**
 * Class for decrypting user message
 *
 * @author Jason Ryan
 */
public class Decryptor {

    private static final int ALPHA_LENGTH = 26;

    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private String decryptedText = "";

    /**
     * Constructor
     *
     * @param encrypted String encrypted text to be decrypted
     * @param keys int[] of keys to use for decryption
     */
    public Decryptor(String encrypted, int[] keys) {
        decrypt(encrypted, keys);
    }

    /**
     * Getter for decryptedText
     *
     * @return String decryptedText
     */
    public String getDecryptedText() {
        return decryptedText;
    }

    /**
     * Decrypts encrypted text using provided keys
     *
     * @param encrypted String text to be decrypted
     * @param keys int[] keys used for decryption
     */
    private void decrypt(String encrypted, int[] keys) {
        char alpha, let, decryptLet;
        int key;
        int keyIt = 0;

        char[] encryptedChars = encrypted.toCharArray();

        for(int i = 0; i < encrypted.length(); i++) {
            key = keys[keyIt];
            let = encryptedChars[i];
            decryptLet = ' ';

            if(let != ' ') {
                for(int j = 0; j < alphabet.length; j++) {
                    alpha = alphabet[j];

                    if(let == alpha)
                        decryptLet = alphabet[(j + ALPHA_LENGTH - key) % 26];
                }

                // Increment key iterator only on non-space character
                keyIt++;
            }

            decryptedText += decryptLet;
        }
    }
}
