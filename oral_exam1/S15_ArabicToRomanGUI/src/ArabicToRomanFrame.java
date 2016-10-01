import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by jasonryan on 9/14/16.
 */
public class ArabicToRomanFrame extends JFrame {

    // Constants for number of columns required in text fields.
    private static final int MAX_ROMAN = 13;
    private static final int MAX_ARABIC = 13;
    private final JTextField romanField;
    private final JTextField arabicField;

    public ArabicToRomanFrame() {
        super("S15_ArabicToRomanGUI");
        setLayout(new FlowLayout(FlowLayout.LEFT));

        romanField = new JTextField(MAX_ROMAN);
        arabicField = new JTextField(MAX_ARABIC);

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


        KeyListener romanKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                arabicField.setText("");
                romanNumeral.setRoman(romanField.getText().toUpperCase());
                romanField.setText(romanNumeral.getRoman());
                arabicField.setText(romanNumeral.convert());
            }
        };

        KeyListener arabicKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                romanField.setText("");
                if(arabicField.getText().length() != 0) {
                    arabicNum.setArabic(Integer.parseInt(arabicField.getText()));
                    romanField.setText(arabicNum.convert(arabicNum.getArabic()));
                }
            }
        };

        arabicField.addKeyListener(arabicKeyListener);
        romanField.addKeyListener(romanKeyListener);
    }
}
