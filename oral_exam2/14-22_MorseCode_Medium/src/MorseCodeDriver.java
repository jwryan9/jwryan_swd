import java.util.Scanner;

/**
 *  Driver program for demonstrating MorseCode converter functionality
 *
 *  @author Jason Ryan
 */
public class MorseCodeDriver {

    /**
     * Main method, allows user interaction through command line interface
     * makes user selected conversion between English and Morse code
     *
     * @param args command line arguments
     */
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
                System.out.println("\n14-22_MorseCode_Medium\nSelect direction to convert:");
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

            // Perform conversions or exit
            if(selection == 1) {
                System.out.println("Enter string to convert:");
                toConvert = kb.nextLine();
                englishToMorse.convert(toConvert);
                converted = englishToMorse.getMorse();
                System.out.println("Converted String: " + converted);
                englishToMorse.reset();
            } else if(selection == 2) {
                System.out.println("Enter string to convert:");
                toConvert = kb.nextLine();
                morseToEnglish.convert(toConvert);
                converted = morseToEnglish.getEnglish();
                System.out.println("Converted String: " + converted);
                morseToEnglish.reset();
            } else if(selection == 3) {
                System.out.println("Exiting...");
            }

        } while(selection != 3);
    }
}
