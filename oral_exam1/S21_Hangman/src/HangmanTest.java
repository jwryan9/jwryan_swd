/**
 * Created by jasonryan on 9/1/16.
 */
public class HangmanTest {
    public static void main(String[] args) {
        String word = Input.requestWord();
        char guess = Input.requestGuess();

        boolean correctGuess = false;

        char[] wordCharArr = word.toCharArray();
        for(char c : wordCharArr)
            if (c == guess) {
                correctGuess = true;
                System.out.println(guess + " is in " + word);
            }
    }
}
