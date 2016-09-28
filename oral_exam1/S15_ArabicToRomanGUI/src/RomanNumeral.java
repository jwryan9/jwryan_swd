/**
 * Created by jasonryan on 9/27/16.
 */
public class RomanNumeral {
    public static boolean isValid(String roman) {

        return roman.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
/*
        if(roman.length() == 1)
            return true;

        // Check for a run of 5 appearances of any numeral
        for(int i = 0; i < romanCharArray.length - 4; i++) {
            if(romanCharArray[i] == romanCharArray[i+1] && romanCharArray[i] == romanCharArray[i+2]
                    && romanCharArray[i] == romanCharArray[i+3] && romanCharArray[i] == romanCharArray[i+4])
                return false;
        }

        // Check for a run of numerals not allowed to make runs.
        for(char notAllowed : runNotAllowed) {
            for (int i = 0; i < romanCharArray.length - 1; i++) {
                if(romanCharArray[i] == notAllowed) {
                    if (romanCharArray[i] == romanCharArray[i + 1])
                        return false;
                }
            }
        }

        return true;*/
    }

}
