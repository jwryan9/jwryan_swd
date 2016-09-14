/**
 * Created by jasonryan on 9/9/16.
 * Input prompts user for input via a dialog box and validates it.
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Input {
    private final static int SPACE = 32;
    private final static int A = 65;
    private final static int Z = 90;


    // Method for entering word to be guessed
    public static String requestWord() {
        String input = JOptionPane.showInputDialog("Enter word for player to guess (No spaces).");
        while(!validWordInput(input))
            input = JOptionPane.showInputDialog("Word invalid. Please enter valid word (No spaces).");

        input.toUpperCase();
        return input;
    }

    // Method for gathering user guess from dialog box
    public static char requestGuess(ArrayList<Character> prevGuesses) {
        String input = JOptionPane.showInputDialog("Enter guess (A-Z).");
        while(!validGuessInput(input, prevGuesses))
            input = JOptionPane.showInputDialog("Guess invalid. Please enter valid guess (A-Z).");
        return input.toCharArray()[0];
    }

    // Method for validating user word to be guessed input
    private static boolean validWordInput(String in) {
        char[] inputCharArr = in.toCharArray();
        for(char c : inputCharArr) {
            if(c == SPACE)
                return false;
        }
        return true;
    }

    // Method for validating user guess input
    private static boolean validGuessInput(String in, ArrayList<Character> prevGuesses) {
        if(in.length() != 1)
            return false;
        else {
            if ((in.toUpperCase().toCharArray()[0] < A) || (in.toUpperCase().toCharArray()[0] > Z))
                return false;
            else {
                // Check if guess has been given before
                for (char guess : prevGuesses) {
                    if (in.toUpperCase().toCharArray().equals(guess))
                        return false;
                }
                return true;
            }
        }
    }
}