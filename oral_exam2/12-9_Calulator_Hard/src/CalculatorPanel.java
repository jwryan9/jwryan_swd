import javax.swing.*;
import java.awt.*;

/**
 * Class creates calculator GUI
 *
 * @author Jason Ryan
 */
public class CalculatorPanel extends JPanel {

    private final JButton zero;
    private final JButton one;
    private final JButton two;
    private final JButton three;
    private final JButton four;
    private final JButton five;
    private final JButton six;
    private final JButton seven;
    private final JButton eight;
    private final JButton nine;

    private final JButton plus;
    private final JButton minus;
    private final JButton multiply;
    private final JButton divide;
    private final JButton equal;
    private final JButton decimal;

    private final JTextField calculatorText;

    /**
     * Constructor
     */
    public CalculatorPanel() {
        super();

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(layout);

        // Instantiate JButtons
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");

        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        equal = new JButton("=");
        decimal = new JButton(".");

        calculatorText = new JTextField("0");

        // Add text field
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.gridwidth = 4;
        add(calculatorText, c);

        c.gridwidth = 1;

        // Add buttons to panel
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        add(seven, c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.5;
        add(eight, c);

        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 0.5;
        add(nine, c);

        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 0.5;
        add(divide, c);

        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        add(four, c);

        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 0.5;
        add(five, c);

        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 0.5;
        add(six, c);

        c.gridx = 3;
        c.gridy = 2;
        c.weightx = 0.5;
        add(multiply, c);

        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0.5;
        add(one, c);

        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 0.5;
        add(two, c);

        c.gridx = 2;
        c.gridy = 3;
        c.weightx = 0.5;
        add(three, c);

        c.gridx = 3;
        c.gridy = 3;
        c.weightx = 0.5;
        add(minus, c);

        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 0.5;
        add(zero, c);

        c.gridx = 1;
        c.gridy = 4;
        c.weightx = 0.5;
        add(decimal, c);

        c.gridx = 2;
        c.gridy = 4;
        c.weightx = 0.5;
        add(equal, c);

        c.gridx = 3;
        c.gridy = 4;
        c.weightx = 0.5;
        add(plus, c);
    }
}
