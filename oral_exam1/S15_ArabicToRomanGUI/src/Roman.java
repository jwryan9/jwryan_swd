import java.util.TreeMap;

/**
 * Created by jasonryan on 9/30/16.
 */
public class Roman {
    private String roman;

    public Roman(String romanNum) {
        roman = romanNum.toUpperCase();
    }

    // Method converts String roman numeral input to integer arabic output
    public String convert() {

        // Validate Roman Numeral input before making conversion
        if(!validateRoman(roman))
            return "Invalid Roman Numeral";

        int arabic = 0, prev = 0, cur = 0;

        TreeMap<Character,Integer> romanArabic = romanArabicTreeMap();

        for(int i = 0; i < roman.length(); i++) {
            cur = romanArabic.get(roman.charAt(i));

            // Logic to account for roman numeral subtraction behavior (4, 9, 40, etc.)
            if (prev != 0 && prev < cur) {
                cur -= prev;
                arabic -= prev;
                arabic += cur;
                prev = cur;
            } else {
                prev = cur;
                arabic += cur;
            }
        }

        return Integer.toString(arabic);
    }

    // Method to set roman String
    public void setRoman(String romanNum) {
        roman = romanNum;
    }

    // Method to get roman String
    public String getRoman() {
        return roman;
    }

    // Method generates a TreeMap with Character keys of Roman Numerals and Integer values of arabic numbers
    private TreeMap<Character, Integer> romanArabicTreeMap() {
        TreeMap<Character, Integer> romanArabicMap = new TreeMap<>();

        romanArabicMap.put('I',1);
        romanArabicMap.put('V',5);
        romanArabicMap.put('X',10);
        romanArabicMap.put('L',50);
        romanArabicMap.put('C',100);
        romanArabicMap.put('D',500);
        romanArabicMap.put('M',1000);

        return romanArabicMap;
    }

    // Method validates Roman Numeral rules
    private boolean validateRoman(String roman) {
        // Regular expression validates Roman Numeral rules
        return roman.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }
}
