import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jason Ryan
 */
public class CalculatorFrame extends JFrame {

    private final CalculatorPanel calculatorPanel;
    private final JTextField calculatorText;

    public CalculatorFrame() {
        super("12-9_Calculator_Hard");
        setLayout(new BorderLayout(10, 10));

        calculatorPanel = new CalculatorPanel();
        calculatorText = new JTextField("Test");

        add(calculatorText, BorderLayout.NORTH);
        add(calculatorPanel, BorderLayout.CENTER);
    }
}
