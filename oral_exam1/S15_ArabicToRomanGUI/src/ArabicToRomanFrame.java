import javax.swing.*;
import java.awt.*;

/**
 * Created by jasonryan on 9/14/16.
 */
public class ArabicToRomanFrame extends JFrame {

    // Constants for number of columns required in text fields.
    private static final int MAX_ROMAN = 9;
    private static final int MAX_ARABIC = 4;

    public ArabicToRomanFrame() {
        super("S15_ArabicToRomanGUI");
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField romanField = new JTextField(MAX_ROMAN);
        JTextField ArabicField = new JTextField(MAX_ARABIC);

        JLabel romanLabel = new JLabel("Roman Numerals: ");
        JLabel arabicLabel = new JLabel("Arabic Digits: ");

        romanLabel.setPreferredSize(new Dimension(150,20));
        arabicLabel.setPreferredSize(new Dimension(150,20));

        add(romanLabel);
        add(romanField);
        add(arabicLabel);
        add(ArabicField);
    }
}