import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jasonryan on 10/4/16.
 */
public class MyColorChooser extends JPanel{

    // Constants
    private final int FIELD_COLS = 3;
    private final int RGB_DEFAULT = 127;

    private final JLabel redLabel;
    private final JLabel greenLabel;
    private final JLabel blueLabel;
    private final JLabel colorLabel;

    private final JSlider redSlider;
    private final JSlider greenSlider;
    private final JSlider blueSlider;

    private final JTextField redField;
    private final JTextField greenField;
    private final JTextField blueField;

    private final JButton resetButton;

    private final RectanglePanel rectanglePanel;

    private int redVal;
    private int greenVal;
    private int blueVal;

    private Color color;

    public MyColorChooser() {
        super();
        setBorder(new EmptyBorder(10, 10, 10, 10));
        GridLayout layout = new GridLayout(4, 3);
         layout.setVgap(20);
        layout.setHgap(10);
        setLayout(layout);


        redLabel = new JLabel("Red:");
        greenLabel = new JLabel("Green:");
        blueLabel = new JLabel("Blue:");
        colorLabel = new JLabel("Color:");

        redSlider = new JSlider(0, 255);
        greenSlider = new JSlider(0, 255);
        blueSlider = new JSlider(0, 255);

        redField = new JTextField(FIELD_COLS);
        greenField = new JTextField(FIELD_COLS);
        blueField = new JTextField(FIELD_COLS);

        rectanglePanel = new RectanglePanel();

        resetButton = new JButton("Reset Color");

        // Set default text field values
        redField.setText(String.valueOf(redSlider.getValue()));
        greenField.setText(String.valueOf(greenSlider.getValue()));
        blueField.setText(String.valueOf(blueSlider.getValue()));

        // Set default color values
        redVal = redSlider.getValue();
        greenVal = greenSlider.getValue();
        blueVal = blueSlider.getValue();

        // Generate default color and set rectangle color
        color = new Color(redVal, greenVal, blueVal);
        rectanglePanel.setColor(color);

        // Add change listeners to sliders
        redSlider.addChangeListener(new SliderChangeHandler());
        greenSlider.addChangeListener(new SliderChangeHandler());
        blueSlider.addChangeListener(new SliderChangeHandler());

        // Add action listeners to text fields
        redField.addActionListener(new FieldActionHandler());
        greenField.addActionListener(new FieldActionHandler());
        blueField.addActionListener(new FieldActionHandler());

        // Add action listener for resetButton
        resetButton.addActionListener(
                e -> {
                    setRed(RGB_DEFAULT);
                    setGreen(RGB_DEFAULT);
                    setBlue(RGB_DEFAULT);

                    color = new Color(redVal, greenVal, blueVal);
                    rectanglePanel.setColor(color);
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
        add(colorLabel);
        add(rectanglePanel);
        add(resetButton);
    }

    // Inner class for slider event handling
    private class SliderChangeHandler implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            redVal = redSlider.getValue();
            greenVal = greenSlider.getValue();
            blueVal = blueSlider.getValue();

            redField.setText(String.valueOf(redVal));
            greenField.setText(String.valueOf(greenVal));
            blueField.setText(String.valueOf(blueVal));

            color = new Color(redVal, greenVal, blueVal);

            rectanglePanel.setColor(color);
        }
    }

    // Inner class for text field event handling
    private class FieldActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                redSlider.setValue(Integer.parseInt(redField.getText()));
            } catch (NumberFormatException ex) {
                redSlider.setValue(RGB_DEFAULT);
                redField.setText(String.valueOf(RGB_DEFAULT));
            }

            try {
                greenSlider.setValue(Integer.parseInt(greenField.getText()));
            } catch (NumberFormatException ex) {
                greenSlider.setValue(RGB_DEFAULT);
                greenField.setText(String.valueOf(RGB_DEFAULT));
            }

            try {
                blueSlider.setValue(Integer.parseInt(blueField.getText()));
            } catch (NumberFormatException ex) {
                blueSlider.setValue(RGB_DEFAULT);
                blueField.setText(String.valueOf(RGB_DEFAULT));
            }

            redVal = redSlider.getValue();
            greenVal = greenSlider.getValue();
            blueVal = blueSlider.getValue();

            color = new Color(redVal, greenVal, blueVal);
            rectanglePanel.setColor(color);
        }
    }

    private void setRed(int red) {
        redVal = red;
        redField.setText(String.valueOf(red));
        redSlider.setValue(red);
    }

    private void setGreen(int green) {
        greenVal = green;
        greenField.setText(String.valueOf(green));
        greenSlider.setValue(green);
    }

    private void setBlue(int blue) {
        blueVal = blue;
        blueField.setText(String.valueOf(blue));
        blueSlider.setValue(blue);
    }
}
