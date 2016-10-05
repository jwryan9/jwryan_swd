import javax.swing.*;
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
        setLayout(new GridLayout(3,2));

        redSlider = new JSlider(0, 255);
        greenSlider = new JSlider(0, 255);
        blueSlider = new JSlider(0, 255);

        redField = new JTextField(FIELD_COLS);
        greenField = new JTextField(FIELD_COLS);
        blueField = new JTextField(FIELD_COLS);

        add(redSlider);
        add(redField);
        add(greenSlider);
        add(greenField);
        add(blueSlider);
        add(blueField);
    }
}
