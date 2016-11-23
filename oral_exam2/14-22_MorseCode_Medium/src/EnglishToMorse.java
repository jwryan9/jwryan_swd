import java.util.Map;
import java.util.TreeMap;

/**
 * Class used to convert English to Morse code
 */
public class EnglishToMorse {
    private Map<Character, String> morseCodeDict;
    private char[] englishCharArr;
    private String english, morse = "";

    /**
     * Constructor sets up TreeMap used in conversion
     */
    public EnglishToMorse(){
        // Create dictionary for morse code conversion
        morseCodeDict = new TreeMap<>();
        morseCodeDict.put('A', ".- ");
        morseCodeDict.put('B', "-... ");
        morseCodeDict.put('C', "-.-. ");
        morseCodeDict.put('D', "-.. ");
        morseCodeDict.put('E', ". ");
        morseCodeDict.put('F', "..-. ");
        morseCodeDict.put('G', "--. ");
        morseCodeDict.put('H', ".... ");
        morseCodeDict.put('I', ".. ");
        morseCodeDict.put('J', ".--- ");
        morseCodeDict.put('K', "-.- ");
        morseCodeDict.put('L', ".-.. ");
        morseCodeDict.put('M', "-- ");
        morseCodeDict.put('N', "-. ");
        morseCodeDict.put('O', "--- ");
        morseCodeDict.put('P', ".--. ");
        morseCodeDict.put('Q', "--.- ");
        morseCodeDict.put('R', ".-. ");
        morseCodeDict.put('S', "... ");
        morseCodeDict.put('T', "- ");
        morseCodeDict.put('U', "..- ");
        morseCodeDict.put('V', "...- ");
        morseCodeDict.put('W', ".-- ");
        morseCodeDict.put('X', "-..- ");
        morseCodeDict.put('Y', "-.-- ");
        morseCodeDict.put('Z', "--.. ");
        morseCodeDict.put('1', ".---- ");
        morseCodeDict.put('2', "..--- ");
        morseCodeDict.put('3', "...-- ");
        morseCodeDict.put('4', "....- ");
        morseCodeDict.put('5', "..... ");
        morseCodeDict.put('6', "-.... ");
        morseCodeDict.put('7', "--... ");
        morseCodeDict.put('8', "---.. ");
        morseCodeDict.put('9', "----. ");
        morseCodeDict.put('0', "----- ");
        morseCodeDict.put(' ', "  ");
    }

    /**
     * Convert English string to Morse code
     *
     * @param english string to convert
     */
    public void convert(final String english) {
        this.english = english.toUpperCase();
        englishCharArr = this.english.toCharArray();
        String morseLetter;
        for(char englishLet : englishCharArr) {

            // Ignore characters not in map
            if(morseCodeDict.containsKey(englishLet)) {
                morseLetter = morseCodeDict.get(englishLet);
                morse += morseLetter;
            }
        }
    }

    /**
     * Getter for Morse string
     *
     * @return Morse code string
     */
    public String getMorse() {
        return morse;
    }

    /**
     * Reset converted Morse string
     */
    public void reset() {
        morse = "";
    }
}
