import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * Created by jasonryan on 9/14/16.
 */
public class Conversion {

    // Method converts String roman numeral input to integer arabic output
    public static String romanToArabic(String roman) {

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

    // Method converts arabic integer input to String roman numeral output recursively
    public static String arabicToRoman(int arabic) {
        int num;

        TreeMap<Integer,String> arabicRoman = arabicRomanTreeMap();

        // Get key to value of greatest entry less than or equal to arabic
        num = arabicRoman.floorEntry(arabic).getKey();

        if(arabic == num)
            return arabicRoman.get(arabic);

        return arabicRoman.get(num) + arabicToRoman(arabic - num);
    }

    // Method generates a TreeMap with Character keys of Roman Numerals and Integer values of arabic numbers
    private static TreeMap<Character, Integer> romanArabicTreeMap() {
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

    // Method generates a TreeMap with Integer keys of arabic numbers and String values of Roman Numerals
    private static TreeMap<Integer, String> arabicRomanTreeMap() {
        TreeMap<Integer, String> arabicRomanMap = new TreeMap<>();

        arabicRomanMap.put(1,"I");
        arabicRomanMap.put(4,"IV");
        arabicRomanMap.put(5,"V");
        arabicRomanMap.put(9,"IX");
        arabicRomanMap.put(10,"X");
        arabicRomanMap.put(40,"XL");
        arabicRomanMap.put(50,"L");
        arabicRomanMap.put(90,"XC");
        arabicRomanMap.put(100,"C");
        arabicRomanMap.put(400,"CD");
        arabicRomanMap.put(500,"D");
        arabicRomanMap.put(900,"CM");
        arabicRomanMap.put(1000,"M");

        return arabicRomanMap;
    }

    // Method validates Roman Numeral rules
    private static boolean validateRoman(String roman) {
        // Regular expression validates Roman Numeral rules
        return roman.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }
}
