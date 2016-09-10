/**
 * Created by jasonryan on 9/9/16.
 * Input prompts user for input via a dialog box and validates it.
 */

import javax.swing.JOptionPane;

public class Input {
    public static char requestGuess() {
        String input = JOptionPane.showInputDialog("Enter guess (A-Z).");
        while(!validInput(input)) {
            input = JOptionPane.showInputDialog("Guess invalid. Please enter valid guess (A-Z).");
        }
        return input.toCharArray()[0];
    }

    private static boolean validInput(String in) {
        if(in.length() != 1)
            return false;
        else {
            if ((in.toUpperCase().toCharArray()[0] < 65) || (in.toUpperCase().toCharArray()[0] > 90))
                return false;
            else
                return true;
        }

    }
}
