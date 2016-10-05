import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by jasonryan on 9/14/16.
 */
public class ArabicToRomanFrame extends JFrame {

    // Constant for number of columns required in text fields.
    private static final int FIELD_COLS = 13;

    private final JTextField romanField;
    private final JTextField arabicField;

    public ArabicToRomanFrame() {
        super("S15_ArabicToRomanGUI");
        setLayout(new FlowLayout(FlowLayout.LEFT));

        romanField = new JTextField(FIELD_COLS);
        arabicField = new JTextField(FIELD_COLS);

        JLabel romanLabel = new JLabel("Roman Numerals: ");
        JLabel arabicLabel = new JLabel("Arabic Digits: ");

        romanLabel.setPreferredSize(new Dimension(150,20));
        arabicLabel.setPreferredSize(new Dimension(150,20));

        add(romanLabel);
        add(romanField);
        add(arabicLabel);
        add(arabicField);

        Roman romanNumeral = new Roman(romanField.getText());
        Arabic arabicNum = new Arabic(arabicField.getText());

        // KeyListener for arabicField updates romanField on keyRelease
        arabicField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                romanField.setText("");

                // Do not attempt conversion if field is blank
                if (arabicField.getText().length() > 0) {
                    arabicNum.setArabic(Integer.parseInt(arabicField.getText()));
                    romanField.setText(arabicNum.convert(arabicNum.getArabic()));
                }
            }
        });

        // KeyListener for romanField updates arabicField on keyRelease
        romanField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                arabicField.setText("");

                // Do not attempt conversion if field is blank
                if(romanField.getText().length() > 0) {
                    romanNumeral.setRoman(romanField.getText().toUpperCase());
                    romanField.setText(romanNumeral.getRoman());
                    arabicField.setText(romanNumeral.convert());
                }
            }
        });

    }
}
