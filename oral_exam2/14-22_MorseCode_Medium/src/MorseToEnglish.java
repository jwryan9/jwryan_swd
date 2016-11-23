import java.util.Map;
import java.util.TreeMap;

/**
 * Class used to convert Morse code to English
 */
public class MorseToEnglish {
    private Map<String, Character> morseCodeDict;
    private String morse, english = "";
    private String[] morseWords, morseLetters;

    /**
     * Constructor sets up TreeMap used in conversion
     */
    public MorseToEnglish() {
        // Create dictionary for morse code conversion
        morseCodeDict = new TreeMap<>();
        morseCodeDict.put(".-", 'A');
        morseCodeDict.put("-...", 'B');
        morseCodeDict.put("-.-.", 'C');
        morseCodeDict.put("-..", 'D');
        morseCodeDict.put(".", 'E');
        morseCodeDict.put("..-.", 'F');
        morseCodeDict.put("--.", 'G');
        morseCodeDict.put("....", 'H');
        morseCodeDict.put("..", 'I');
        morseCodeDict.put(".---", 'J');
        morseCodeDict.put("-.-", 'K');
        morseCodeDict.put(".-..", 'L');
        morseCodeDict.put("--", 'M');
        morseCodeDict.put("-.", 'N');
        morseCodeDict.put("---", 'O');
        morseCodeDict.put(".--.", 'P');
        morseCodeDict.put("--.-", 'Q');
        morseCodeDict.put(".-.", 'R');
        morseCodeDict.put("...", 'S');
        morseCodeDict.put("-", 'T');
        morseCodeDict.put("..-", 'U');
        morseCodeDict.put("...-", 'V');
        morseCodeDict.put(".--", 'W');
        morseCodeDict.put("-..-", 'X');
        morseCodeDict.put("-.--", 'Y');
        morseCodeDict.put("--..", 'Z');
        morseCodeDict.put(".----", '1');
        morseCodeDict.put("..---", '2');
        morseCodeDict.put("...--", '3');
        morseCodeDict.put("....-", '4');
        morseCodeDict.put(".....", '5');
        morseCodeDict.put("-....", '6');
        morseCodeDict.put("--...", '7');
        morseCodeDict.put("---..", '8');
        morseCodeDict.put("----.", '9');
        morseCodeDict.put("-----", '0');
        morseCodeDict.put("   ", ' ');
    }

    /**
     * Convert Morse code string to English
     *
     * @param morse string to convert
     */
    public void convert(String morse) {
        this.morse = morse;

        morseWords = morse.split("   ");
        for(String word : morseWords) {
            morseLetters = word.split(" ");
            for(String morseLet : morseLetters) {
                english += morseCodeDict.get(morseLet);
            }
            english += " ";
        }
    }

    /**
     * Getter for English string
     *
     * @return English string
     */
    public String getEnglish() {
        return english;
    }
}
