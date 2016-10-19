import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel to implement ColorChooser functionality and display it to the user
 *
 * @author Jason Ryan
 */
public class MyColorChooser extends JPanel{

    // Constants
    private final int FIELD_COLS = 3;
    private final int RGB_DEFAULT = 127;
    private final int RGB_MIN = 0;
    private final int RGB_MAX = 255;
    private final int TICK_SPACING = 17;

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

    /**
     * Constructor, instantiates all objects needed for panel and adds them
     */
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

        resetButton = new JButton("Reset Color");

        // Set default text field values
        redField.setText(String.valueOf(redSlider.getValue()));
        greenField.setText(String.valueOf(greenSlider.getValue()));
        blueField.setText(String.valueOf(blueSlider.getValue()));

        // Set default color values
        redVal = redSlider.getValue();
        greenVal = greenSlider.getValue();
        blueVal = blueSlider.getValue();

        // Add ticks to sliders
        redSlider.setMajorTickSpacing(TICK_SPACING);
        greenSlider.setMajorTickSpacing(TICK_SPACING);
        blueSlider.setMajorTickSpacing(TICK_SPACING);
        redSlider.setPaintTicks(true);
        greenSlider.setPaintTicks(true);
        blueSlider.setPaintTicks(true);

        // Instantiate RectanglePanel
        rectanglePanel = new RectanglePanel(redVal, greenVal, blueVal);

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

                    rectanglePanel.setRedVal(redVal);
                    rectanglePanel.setGreenVal(greenVal);
                    rectanglePanel.setBlueVal(blueVal);
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

    /**
     * Inner class for JSlider event handling
     */
    private class SliderChangeHandler implements ChangeListener {

        /**
         * Adjusts color values in MyColorChooser and RectanglePanel upon JSlider state change
         *
         * @param e ChangeEvent
         */
        @Override
        public void stateChanged(ChangeEvent e) {
            setRed(redSlider.getValue());
            setGreen(greenSlider.getValue());
            setBlue(blueSlider.getValue());

            rectanglePanel.setRedVal(redVal);
            rectanglePanel.setGreenVal(greenVal);
            rectanglePanel.setBlueVal(blueVal);
        }
    }

    /**
     * Inner class for JTextField event handling
     */
    private class FieldActionHandler implements ActionListener {

        /**
         * Adjusts color values in MyColorChooser and RectanglePanel upon JTextField update
         *
         * @param e ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            // When user enters invalid input, maintain state
            try {
                setRed(Integer.parseInt(redField.getText()));
            } catch (Exception ex) {
                setRed(redSlider.getValue());
                rectanglePanel.setRedVal(redVal);
            }

            try {
                setGreen(Integer.parseInt(greenField.getText()));
            } catch (Exception ex) {
                setGreen(greenSlider.getValue());
                rectanglePanel.setGreenVal(greenVal);
            }

            try {
                setBlue(Integer.parseInt(blueField.getText()));
            } catch (Exception ex) {
                setBlue(blueSlider.getValue());
                rectanglePanel.setBlueVal(blueVal);
            }
        }
    }

    /**
     * Sets redVal, redField, and redSlider to value passed
     *
     * @param red integer of new red value
     * @throws IllegalArgumentException thrown when an invalid value is passed
     */
    private void setRed(int red) throws IllegalArgumentException {
        if(red < RGB_MIN || red > RGB_MAX)
            throw new IllegalArgumentException();
        else {
            redVal = red;
            redField.setText(String.valueOf(red));
            redSlider.setValue(red);
        }
    }

    /**
     * Sets greenVal, greenField, and greenSlider to value passed
     *
     * @param green integer of new green value
     * @throws IllegalArgumentException thrown when an invalid value is passed
     */
    private void setGreen(int green) throws IllegalArgumentException {
        if(green < RGB_MIN || green > RGB_MAX)
            throw new IllegalArgumentException();
        else {
            greenVal = green;
            greenField.setText(String.valueOf(green));
            greenSlider.setValue(green);
        }
    }

    /**
     * Sets blueVal, blueField, and blueSlider to value passed
     *
     * @param blue integer of new blue value
     * @throws IllegalArgumentException thrown when an invalid value is passed
     */
    private void setBlue(int blue) throws IllegalArgumentException {
        if(blue < RGB_MIN || blue > RGB_MAX)
            throw new IllegalArgumentException();
        else {
            blueVal = blue;
            blueField.setText(String.valueOf(blue));
            blueSlider.setValue(blue);
        }
    }
}
