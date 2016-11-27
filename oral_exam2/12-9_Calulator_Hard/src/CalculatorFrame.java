import javax.swing.*;
import java.awt.*;

/**
 * GUI frame that contains calculator panel
 *
 * @author Jason Ryan
 */
public class CalculatorFrame extends JFrame {

    private final CalculatorPanel calculatorPanel;

    /**
     * Constructor. Initializes JFrame and adds new CalculatorPanel  to frame.
     */
    public CalculatorFrame() {
        super("12-9_Calculator_Hard");

        calculatorPanel = new CalculatorPanel();

        add(calculatorPanel);
    }
}
