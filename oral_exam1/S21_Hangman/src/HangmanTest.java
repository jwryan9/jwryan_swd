import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by jasonryan on 9/1/16.
 */
public class HangmanTest {
    public static void main(String[] args) {
        String word;
        ArrayList<Character> guesses = new ArrayList<>();
        ArrayList<Character> incorrectGuesses = new ArrayList<>();
        char guess;
        boolean correctGuess;

        word = Input.requestWord();
        guess = Input.requestGuess(guesses);

        guesses.add(guess);
        System.out.println(guesses);
        correctGuess = Hangman.checkGuess(word, guess);
        if(!correctGuess) {
            incorrectGuesses.add(guess);
            System.out.println(incorrectGuesses);
        }
    }
}
