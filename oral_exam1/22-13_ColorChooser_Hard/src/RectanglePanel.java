import javax.swing.*;
import java.awt.*;

/**
 * Panel to implement rectangle drawing functionality
 *
 * @author Jason Ryan
 */
public class RectanglePanel extends JPanel {

    private Color color;
    private int redVal;
    private int greenVal;
    private int blueVal;

    /**
     * Constructor
     *
     * @param red integer red rgb value
     * @param green integer green rgb value
     * @param blue integer blue rgb value
     */
    RectanglePanel(int red, int green, int blue) {
        setRedVal(red);
        setGreenVal(green);
        setBlueVal(blue);
    }

    /**
     * Paints filled rectangle of set color
     *
     * @param g Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(10,10,150,100);
    }

    /**
     * Setter for redVal, updates redVal, creates new color, and repaints
     *
     * @param redVal integer red rgb value
     */
    public void setRedVal(int redVal) {
        this.redVal = redVal;
        color = new Color(redVal, greenVal, blueVal);
        repaint();
    }

    /**
     * Setter for greenVal, updates greenVal, creates new color, and repaints
     *
     * @param greenVal integer green rgb value
     */
    public void setGreenVal(int greenVal) {
        this.greenVal = greenVal;
        color = new Color(redVal, greenVal, blueVal);
        repaint();
    }

    /**
     * Setter for blueVal, updates blueVal, creates new color, and repaints
     *
     * @param blueVal integer blue rgb value
     */
    public void setBlueVal(int blueVal) {
        this.blueVal = blueVal;
        color = new Color(redVal, greenVal, blueVal);
        repaint();
    }
}
