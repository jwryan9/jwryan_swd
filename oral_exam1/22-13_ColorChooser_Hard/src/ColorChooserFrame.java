import javax.swing.*;
import java.awt.*;

/**
 * Frame to hold MyColorChooser panel
 *
 * @author JAson Ryan
 */
public class ColorChooserFrame extends JFrame {

    /**
     * Constructor, initializes frame and adds MyColorChooser panel
     */
    public ColorChooserFrame() {
        super("22-13_ColorChooser");

        MyColorChooser colorChooserPanel = new MyColorChooser();
        colorChooserPanel.setPreferredSize(new Dimension(300,200));

        add(colorChooserPanel);
    }
}
