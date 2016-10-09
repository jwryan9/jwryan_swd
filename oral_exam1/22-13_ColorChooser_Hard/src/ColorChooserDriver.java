import javax.swing.*;

/**
 * Driver class to show off ColorChooser functionality
 *
 * @author Jason Ryan
 */
public class ColorChooserDriver {

    /**
     * Main method of ColorChooserDriver
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ColorChooserFrame colorFrame = new ColorChooserFrame();
        colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorFrame.setSize(500,300);
        colorFrame.setVisible(true);
    }
}
