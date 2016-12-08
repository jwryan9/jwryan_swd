/**
 * Implements calculator logic
 *
 * @author Jason Ryan
 */
public class CalculatorLogic {

    /**
     * Performs basic mathematical calculations
     *
     * @param num1 first number used in calculation
     * @param num2 second number used in calculation
     * @param operator character representing mathematical operation to be performed
     * @return result of the mathematical operation
     */
    public static double calculate(double num1, double num2, char operator) {
        double result = 0;

        if(operator == '+') {
            result = num1 + num2;
        } else if(operator == '-') {
            result = num1 - num2;
        } else if(operator == '*') {
            result = num1 * num2;
        } else if(operator == '/') {
            result = num1 / num2;
        }

        return result;
    }

}
