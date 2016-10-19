import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jason Ryan
 */
public class CalculatorFrame extends JFrame {

    private final CalculatorPanel calculatorPanel;

    public CalculatorFrame() {
        super("12-9_Calculator_Hard");

        calculatorPanel = new CalculatorPanel();

        add(calculatorPanel);
    }
}
