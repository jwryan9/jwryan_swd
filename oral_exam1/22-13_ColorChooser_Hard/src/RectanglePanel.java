import javax.swing.*;
import java.awt.*;

/**
 * Created by jasonryan on 10/5/16.
 */
public class RectanglePanel extends JPanel {

    private Color color;
    private int redVal;
    private int greenVal;
    private int blueVal;

    RectanglePanel(int red, int green, int blue) {
        setRedVal(red);
        setGreenVal(green);
        setBlueVal(blue);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(10,10,150,100);
    }

    public void setRedVal(int redVal) {
        this.redVal = redVal;
        color = new Color(redVal, greenVal, blueVal);
        repaint();
    }

    public void setGreenVal(int greenVal) {
        this.greenVal = greenVal;
        color = new Color(redVal, greenVal, blueVal);
        repaint();
    }

    public void setBlueVal(int blueVal) {
        this.blueVal = blueVal;
        color = new Color(redVal, greenVal, blueVal);
        repaint();
    }
}
