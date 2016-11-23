import java.util.Scanner;

/**
 *  Created by jasonryan on 11/22/16.
 */
public class MorseCodeDriver {

    public static void main(String[] args) {
        String toConvert, converted;
        int selection;
        Scanner kb = new Scanner(System.in);

        EnglishToMorse englishToMorse = new EnglishToMorse();
        MorseToEnglish morseToEnglish = new MorseToEnglish();

        // Loop while user does not wish to exit
        do {
            // Gather valid user input
            do {
                // Display menu
                System.out.println("14-22_MorseCode_Medium\nSelect direction to convert:");
                System.out.println("\n1. English to Morse");
                System.out.println("2. Morse to English");
                System.out.println("3. Exit");

                try {
                    selection = kb.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid Selection");
                    selection = -1;
                }

                // Clear line
                kb.nextLine();
            } while (selection > 3 || selection < 1);

            if(selection == 1) {
                System.out.println("Enter string to convert:");
                toConvert = kb.nextLine();
                englishToMorse.convert(toConvert);
                converted = englishToMorse.getMorse();
                System.out.println("Converted String: " + converted);
            } else if(selection == 2) {
                System.out.println("Enter string to convert:");
                toConvert = kb.nextLine();
                morseToEnglish.convert(toConvert);
                converted = morseToEnglish.getEnglish();
                System.out.println("Conveted String: " + converted);
            } else if(selection == 3) {
                System.out.println("Exiting...");
            }

            toConvert = "";
            converted = "";

        } while(selection != 3);
    }
}
