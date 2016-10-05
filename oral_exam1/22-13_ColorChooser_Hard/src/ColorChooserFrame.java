import javax.swing.*;
import java.awt.*;

/**
 * Created by jasonryan on 10/4/16.
 */
public class ColorChooserFrame extends JFrame {
    public ColorChooserFrame() {
        super("22-13_ColorChooser");
        setLayout(new BorderLayout(10, 20));
        add(new MyColorChooser(), BorderLayout.WEST);
        add(new RectanglePanel(), BorderLayout.EAST);
    }
}
