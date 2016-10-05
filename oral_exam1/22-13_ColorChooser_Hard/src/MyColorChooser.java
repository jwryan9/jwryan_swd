import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by jasonryan on 10/4/16.
 */
public class MyColorChooser extends JPanel{

    // Constants
    private final int FIELD_COLS = 3;

    private final JLabel redLabel;
    private final JLabel greenLabel;
    private final JLabel blueLabel;

    private final JSlider redSlider;
    private final JSlider greenSlider;
    private final JSlider blueSlider;

    private final JTextField redField;
    private final JTextField greenField;
    private final JTextField blueField;

    private int redVal;
    private int greenVal;
    private int blueVal;

    private Color color;

    public MyColorChooser() {
        super();
        setBorder(new EmptyBorder(10, 10, 10, 10));
        GridLayout layout = new GridLayout(3,3);
        layout.setVgap(20);
        layout.setHgap(10);
        setLayout(layout);


        redLabel = new JLabel("Red:");
        greenLabel = new JLabel("Green:");
        blueLabel = new JLabel("Blue:");

        redSlider = new JSlider(0, 255);
        greenSlider = new JSlider(0, 255);
        blueSlider = new JSlider(0, 255);

        redField = new JTextField(FIELD_COLS);
        greenField = new JTextField(FIELD_COLS);
        blueField = new JTextField(FIELD_COLS);

        // Set default text field values
        redField.setText(String.valueOf(redSlider.getValue()));
        greenField.setText(String.valueOf(greenSlider.getValue()));
        blueField.setText(String.valueOf(blueSlider.getValue()));

        // Set default color values
        redVal = redSlider.getValue();
        greenVal = greenSlider.getValue();
        blueVal = blueSlider.getValue();

        // Generate default color
        color = new Color(redVal, greenVal, blueVal);

        redSlider.addChangeListener(
                e -> {
                    redVal = redSlider.getValue();
                    redField.setText(String.valueOf(redVal));
                    color = new Color(redVal, greenVal, blueVal);
                }
        );

        greenSlider.addChangeListener(
                e -> {
                    greenVal = greenSlider.getValue();
                    greenField.setText(String.valueOf(greenSlider.getValue()));
                    color = new Color(redVal, greenVal, blueVal);
                }
        );

        blueSlider.addChangeListener(
                e -> {
                    blueVal = blueSlider.getValue();
                    blueField.setText(String.valueOf(blueSlider.getValue()));
                    color = new Color(redVal, greenVal, blueVal);

                }
        );

        redField.addActionListener(
                e -> {
                    // Catch exception when non numeric value is placed in text field
                    try {
                        redSlider.setValue(Integer.parseInt(redField.getText()));
                    } catch (NumberFormatException ex) {
                        redSlider.setValue(127);
                        redField.setText("127");
                    }

                    redVal = redSlider.getValue();
                    color = new Color(redVal, greenVal, blueVal);
                }
        );

        greenField.addActionListener(
                e -> {
                    try {
                        greenSlider.setValue(Integer.parseInt(greenField.getText()));
                    } catch (NumberFormatException ex) {
                        greenSlider.setValue(127);
                        greenField.setText("127");
                    }

                    greenVal = greenSlider.getValue();
                    color = new Color(redVal, greenVal, blueVal);
                }
        );

        blueField.addActionListener(
                e -> {
                    try {
                        blueSlider.setValue(Integer.parseInt(blueField.getText()));
                    } catch (NumberFormatException ex) {
                        blueSlider.setValue(127);
                        blueField.setText("127");
                    }

                    blueVal = blueSlider.getValue();
                    color = new Color(redVal, greenVal, blueVal);
                }
        );

        add(redLabel);
        add(redSlider);
        add(redField);
        add(greenLabel);
        add(greenSlider);
        add(greenField);
        add(blueLabel);
        add(blueSlider);
        add(blueField);
    }


}
