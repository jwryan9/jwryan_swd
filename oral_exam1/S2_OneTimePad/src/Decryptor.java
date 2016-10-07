/**
 * Created by jasonryan on 9/1/16.
 */
public class Decryptor {

    private static final int ALPHA_LENGTH = 26;

    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public static String decrypt(String encrypted, int[] keys) {
        String decrypted = "";
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

            decrypted += decryptLet;
        }

        return decrypted;
    }
}
