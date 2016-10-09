import javax.swing.*;

/**
 * Driver class to show off ColorChooser functionality
 */
public class ColorChooserDriver {
    public static void main(String[] args) {
        ColorChooserFrame colorFrame = new ColorChooserFrame();
        colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorFrame.setSize(500,300);
        colorFrame.setVisible(true);
    }
}
