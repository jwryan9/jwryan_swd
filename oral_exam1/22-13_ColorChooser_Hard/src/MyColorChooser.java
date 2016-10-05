import javax.swing.*;
import java.awt.*;

/**
 * Created by jasonryan on 10/4/16.
 */
public class MyColorChooser extends JPanel{
    private final int FIELD_COLS = 3;

    private final JSlider redSlider;
    private final JSlider greenSlider;
    private final JSlider blueSlider;

    private final JTextField redField;
    private final JTextField greenField;
    private final JTextField blueField;

    public MyColorChooser() {
        super();
        setLayout(new GridLayout(2,3));

        redSlider = new JSlider(0, 255);
        greenSlider = new JSlider(0, 255);
        blueSlider = new JSlider(0, 255);

        add(redSlider);
        add(greenSlider);
        add(blueSlider);

        redField = new JTextField(FIELD_COLS);
        greenField = new JTextField(FIELD_COLS);
        blueField = new JTextField(FIELD_COLS);

        add(redField);
        add(greenField);
        add(blueField);
    }
}
