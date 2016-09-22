import javax.swing.*;

/**
 * Created by jasonryan on 9/14/16.
 */
public class ArabicToRomanDriver {
    public static void main(String args[]) {

        /*
        ArabicToRomanFrame frame = new ArabicToRomanFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        */

        for (int i = 1; i < 100; i++) {
            System.out.println(i + " = " + Conversion.arabicToRoman(i)
                                + " = " + Conversion.romanToArabic(Conversion.arabicToRoman(i)));
        }


    }
}
