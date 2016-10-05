import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by jasonryan on 10/4/16.
 */
public class MyColorChooser extends JPanel{

    // Constants
    private final int FIELD_COLS = 3;

    private final JSlider redSlider;
    private final JSlider greenSlider;
    private final JSlider blueSlider;

    private final JTextField redField;
    private final JTextField greenField;
    private final JTextField blueField;

    public MyColorChooser() {
        super();
        setBorder(new EmptyBorder(10, 10, 10, 10));
        GridLayout layout = new GridLayout(3,3);
        layout.setVgap(20);
        layout.setHgap(10);
        setLayout(layout);


        JLabel redLabel = new JLabel("Red:");
        JLabel greenLabel = new JLabel("Green:");
        JLabel blueLabel = new JLabel("Blue:");

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
