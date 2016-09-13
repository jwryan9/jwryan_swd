/**
 * Created by jasonryan on 9/13/16.
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Hangman {
    public static void drawGame(ArrayList<Character> previous, String word, int guessesRemain) {
        JOptionPane.showMessageDialog(null, "Previous Guesses: " + previous + "\nGuesses Remaining: " + guessesRemain);
        if(guessesRemain != 0) {
            Input.requestGuess(previous);
        }
    }

    // Method for checking if user guess is in the word, returns occurrences of character guess
    public static boolean checkGuess(String word, char guess) {
        boolean correctGuess = false;

        char[] wordCharArr = word.toCharArray();
        for (char c : wordCharArr) {
            if(c == guess) {
                correctGuess = true;
                System.out.println(guess + " is in " + word);
            }
        }

        return correctGuess;
    }
}
