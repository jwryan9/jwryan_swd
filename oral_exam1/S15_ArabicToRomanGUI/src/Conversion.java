import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * Created by jasonryan on 9/14/16.
 */
public class Conversion {


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
}
