import java.util.TreeMap;

/**
 * Created by jasonryan on 9/30/16.
 */
public class Arabic {
    private int arabic;

    // Constructor
    public Arabic(String arabicStr) {
        if(arabicStr.length() != 0)
            arabic = Integer.parseInt(arabicStr);
        else
            arabic = 0;
    }

    // Method for converting arabic numbers to Roman Numerals
    public String convert(int arabic) {
        if(arabic > 3999 || arabic < 1)
            return "Invalid Arabic Number";

        int num;

        TreeMap<Integer,String> arabicRoman = arabicRomanTreeMap();

        // Get key to value of greatest entry less than or equal to arabic
        num = arabicRoman.floorEntry(arabic).getKey();

        if(arabic == num)
            return arabicRoman.get(arabic);

        return arabicRoman.get(num) + convert(arabic - num);
    }

    // Method to set value of arabic
    public void setArabic(int num) {
        arabic = num;
    }

    // Method to get value of arabic
    public int getArabic() {
        return arabic;
    }

    // Method generates a TreeMap with Integer keys of arabic numbers and String values of Roman Numerals
    private TreeMap<Integer, String> arabicRomanTreeMap() {
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

    private boolean validateArabic(int arabic) {
        if (arabic < 1 || arabic > 3999)
            return false;
        return true;
    }
}
