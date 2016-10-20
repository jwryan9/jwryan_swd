import javax.swing.*;

/**
 * Driver class to show off the capabilities of Calculator
 *
 * @author Jason Ryan
 */
public class CalculatorDriver {
    public static void main(String[] args) {
        CalculatorFrame calculatorFrame = new CalculatorFrame();
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setSize(350,180);
        calculatorFrame.setVisible(true);
    }
}
