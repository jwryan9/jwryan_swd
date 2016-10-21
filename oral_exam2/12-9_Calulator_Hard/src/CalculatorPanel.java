import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates and implements calculator GUI
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

    private double num1;
    private double num2;

    private char operator = '\u0000';
    private char prevOperator = '\u0000';

    private boolean enteringNum = false;

    /**
     * Creates a calculator panel with display text field and buttons for 0-9 and basic mathematical functions
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

        calculatorText = new JTextField();
        calculatorText.setEditable(false);

        // Add handlers
        zero.addActionListener(new NumButtonHandler());
        one.addActionListener(new NumButtonHandler());
        two.addActionListener(new NumButtonHandler());
        three.addActionListener(new NumButtonHandler());
        four.addActionListener(new NumButtonHandler());
        five.addActionListener(new NumButtonHandler());
        six.addActionListener(new NumButtonHandler());
        seven.addActionListener(new NumButtonHandler());
        eight.addActionListener(new NumButtonHandler());
        nine.addActionListener(new NumButtonHandler());
        decimal.addActionListener(new NumButtonHandler());

        plus.addActionListener(new OpButtonHandler());
        minus.addActionListener(new OpButtonHandler());
        multiply.addActionListener(new OpButtonHandler());
        divide.addActionListener(new OpButtonHandler());

        equal.addActionListener(e -> {

            // On equal button press if operator is selected compute with that operation otherwise repeat previous operation
            if(operator != '\u0000') {
                try {
                    num2 = Double.parseDouble(calculatorText.getText());
                } catch (NumberFormatException ex) {
                    calculatorText.setText("Invalid Number");
                }
                calculatorText.setText(String.valueOf(CalculatorLogic.calculate(num1, num2, operator)));
                prevOperator = operator;
                operator = '\u0000';
            } else {
                try {
                    num1 = Double.parseDouble(calculatorText.getText());
                } catch (NumberFormatException ex) {
                    calculatorText.setText("Invalid Number");
                }
                calculatorText.setText(String.valueOf(CalculatorLogic.calculate(num1, num2, prevOperator)));
            }

            operator = '\u0000';
            enteringNum = false;
        });

        // Add text field
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridwidth = 4;
        add(calculatorText, c);

        c.gridwidth = 1;

        // Add buttons to panel
        c.gridx = 0;
        c.gridy = 1;
        add(seven, c);

        c.gridx = 1;
        add(eight, c);

        c.gridx = 2;
        add(nine, c);

        c.gridx = 3;
        add(divide, c);

        c.gridx = 0;
        c.gridy = 2;
        add(four, c);

        c.gridx = 1;
        add(five, c);

        c.gridx = 2;
        add(six, c);

        c.gridx = 3;
        add(multiply, c);

        c.gridx = 0;
        c.gridy = 3;
        add(one, c);

        c.gridx = 1;
        add(two, c);

        c.gridx = 2;
        add(three, c);

        c.gridx = 3;
        add(minus, c);

        c.gridx = 0;
        c.gridy = 4;
        add(zero, c);

        c.gridx = 1;
        add(decimal, c);

        c.gridx = 2;
        add(equal, c);

        c.gridx = 3;
        add(plus, c);
    }

    /**
     * Implementation of ActionListener for number and decimal button presses
     */
    private class NumButtonHandler implements ActionListener {

        /**
         * Invoked when action is performed
         *
         * @param e ActionEvent of button press
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(enteringNum) {
                calculatorText.setText(calculatorText.getText() + e.getActionCommand());
            } else {
                calculatorText.setText("" + e.getActionCommand());
                enteringNum = true;
            }
        }
    }

    /**
     * Implementation of ActionListener for operation button presses
     */
    private class OpButtonHandler implements ActionListener {

        /**
         * Invoked when action is performed
         *
         * @param e ActionEvent of button press
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform calculation for operation already input
            if(operator != '\u0000') {
                try {
                    num2 = Double.parseDouble(calculatorText.getText());
                    num1 = CalculatorLogic.calculate(num1, num2, operator);
                    calculatorText.setText(String.valueOf(num1));
                } catch (NumberFormatException ex) {
                    calculatorText.setText("Invalid Number");
                }
            } else {
                try {
                    num1 = Double.parseDouble(calculatorText.getText());
                } catch (NumberFormatException ex) {
                    calculatorText.setText("Invalid Number");
                }
            }

            enteringNum = false;
            operator = e.getActionCommand().charAt(0);
        }
    }

}
