/**
 *  Created by jasonryan on 11/22/16.
 */
public class MorseCodeDriver {

    public static void main(String[] args) {
        String morse, english;

        EnglishToMorse englishToMorse = new EnglishToMorse();
        englishToMorse.convert("Testing English to Morse code");
        morse = englishToMorse.getMorse();

        System.out.println(morse);

        MorseToEnglish morseToEnglish = new MorseToEnglish();
        morseToEnglish.convert(morse);
        english = morseToEnglish.getEnglish();

        System.out.println(english);
    }
}
