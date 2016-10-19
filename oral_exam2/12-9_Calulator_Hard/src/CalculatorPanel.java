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

    /**
     * Constructor
     */
    public CalculatorPanel() {
        super();
        GridLayout layout = new GridLayout(4, 4);
        layout.setHgap(5);
        layout.setVgap(5);
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

        // Add buttons to panel
        add(seven);
        add(eight);
        add(nine);
        add(divide);
        add(four);
        add(five);
        add(six);
        add(multiply);
        add(one);
        add(two);
        add(three);
        add(minus);
        add(zero);
        add(decimal);
        add(equal);
        add(plus);
    }
}
