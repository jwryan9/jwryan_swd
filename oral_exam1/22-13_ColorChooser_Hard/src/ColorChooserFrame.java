import javax.swing.*;
import java.awt.*;

/**
 * Created by jasonryan on 10/4/16.
 */
public class ColorChooserFrame extends JFrame {
    public ColorChooserFrame() {
        super("22-13_ColorChooser");

        MyColorChooser colorChooserPanel = new MyColorChooser();
        colorChooserPanel.setPreferredSize(new Dimension(300,200));

        add(colorChooserPanel);
    }
}
