import java.util.TreeMap;

/**
 * Class for Arabic numbers
 *
 * @author Jason Ryan
 */
public class Arabic {
    private int arabic;

    /**
     * Constructor
     *
     * @param arabicStr String of Arabic numbers
     */
    public Arabic(String arabicStr) {
        if(arabicStr.length() != 0)
            arabic = Integer.parseInt(arabicStr);
        else
            arabic = 0;
    }

    /**
     * Converts Arabic numbers to Roman Numerals
     *
     * @param arabic int Arabic number to be converted
     * @return String Roman Numeral equivalent ot Arabic number passed in
     */
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

    /**
     * Setter method for arabic
     *
     * @param num int new Arabic number
     */
    public void setArabic(int num) {
        arabic = num;
    }

    /**
     * Getter method for arabic
     *
     * @return int value of Arabic number
     */
    public int getArabic() {
        return arabic;
    }

    /**
     * Generates TreeMap of matching Arabic and Roman Numeral values
     *
     * @return TreeMap of mathcing Arabic and Roman Numeral values
     */
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
}
