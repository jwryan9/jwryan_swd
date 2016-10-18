import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jason Ryan
 */
public class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        super("12-9_Calculator_Hard");
        setLayout(new BorderLayout(10, 10));

        CalculatorPanel calculatorPanel = new CalculatorPanel();

        add(calculatorPanel);
    }
}
