import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jasonryan on 11/22/16.
 */
public class MorseCodeDriver {
    private static String morse;

    public static void main(String[] args) {

        EnglishToMorse englishToMorse = new EnglishToMorse();
        englishToMorse.convert("Testing English to Morse code");
        morse = englishToMorse.getMorse();

        System.out.println(morse);
    }
}
