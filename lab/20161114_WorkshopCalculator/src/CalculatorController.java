import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.math.BigDecimal;

/**
 * Created by Daniel on 11/13/2016.
 */
public class CalculatorController {
    // Declare instance variables
    @FXML
    private Button zero;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button clear;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button divide;
    @FXML
    private Button multiply;
    @FXML
    private Button equals;
    @FXML
    private TextField calculatorText;
    private BigDecimal displayNumber = new BigDecimal(0.00);
    private BigDecimal nomial1 = new BigDecimal(0.00);
    private boolean[] calculationFlags = new boolean[4];
    private CalculatorModel model = new CalculatorModel();

    public void actionPerformed(ActionEvent event) {
        System.out.println("Test");
        if(event.getSource()==zero||event.getSource()==one||event.getSource()==two||event.getSource()==three||
                event.getSource()==four||event.getSource()==five||event.getSource()==six||event.getSource()==seven||
                event.getSource()==eight||event.getSource()==nine) {
            if (event.getSource() == zero) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0));
            } else if (event.getSource() == one) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(1.0));
            } else if (event.getSource() == two) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(2.0));
            } else if (event.getSource() == three) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(3.0));
            } else if (event.getSource() == four) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(4.0));
            } else if (event.getSource() == five) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(5.0));
            } else if (event.getSource() == six) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(6.0));
            } else if (event.getSource() == seven) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(7.0));
            } else if (event.getSource() == eight) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(8.0));
            } else if (event.getSource() == nine) {
                displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(9.0));
            }
            calculatorText.setText(displayNumber.toString());
        } else if(event.getSource()==clear) {
            displayNumber.equals(new BigDecimal(0.00));
            calculatorText.setText(displayNumber.toString());
        } else if(event.getSource()==plus||event.getSource()==minus||event.getSource()==divide||event.getSource()==multiply||event.getSource()==equals) {
            nomial1 = model.calculate(nomial1, displayNumber, calculationFlags);
            displayNumber.equals(new BigDecimal(0.00));
            if (event.getSource() == plus) {
                calculationFlags[0] = true;
                calculatorText.setText("+");
            } else if (event.getSource() == minus) {
                calculationFlags[1] = true;
                calculatorText.setText("-");
            } else if (event.getSource() == divide) {
                calculationFlags[2] = true;
                calculatorText.setText("/");
            } else if (event.getSource() == multiply) {
                calculationFlags[3] = true;
                calculatorText.setText("*");
            } else if (event.getSource() == equals) {
                calculatorText.setText(nomial1.toString());
            }
        }
    }

    /*
    private class ButtonHandler implements ActionListener {
        // Declare local variables
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Test");
            if(event.getSource()==zero||event.getSource()==one||event.getSource()==two||event.getSource()==three||
                    event.getSource()==four||event.getSource()==five||event.getSource()==six||event.getSource()==seven||
                    event.getSource()==eight||event.getSource()==nine) {
                if (event.getSource() == zero) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0));
                } else if (event.getSource() == one) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(1.0));
                } else if (event.getSource() == two) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(2.0));
                } else if (event.getSource() == three) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(3.0));
                } else if (event.getSource() == four) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(4.0));
                } else if (event.getSource() == five) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(5.0));
                } else if (event.getSource() == six) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(6.0));
                } else if (event.getSource() == seven) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(7.0));
                } else if (event.getSource() == eight) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(8.0));
                } else if (event.getSource() == nine) {
                    displayNumber = displayNumber.multiply(new BigDecimal(10.0)).add(new BigDecimal(9.0));
                }
                calculatorText.setText(displayNumber.toString());
            } else if(event.getSource()==clear) {
                displayNumber.equals(new BigDecimal(0.00));
                calculatorText.setText(displayNumber.toString());
            } else if(event.getSource()==plus||event.getSource()==minus||event.getSource()==divide||event.getSource()==multiply||event.getSource()==equals) {
                nomial1 = model.calculate(nomial1, displayNumber, calculationFlags);
                displayNumber.equals(new BigDecimal(0.00));
                if (event.getSource() == plus) {
                    calculationFlags[0] = true;
                    calculatorText.setText("+");
                } else if (event.getSource() == minus) {
                    calculationFlags[1] = true;
                    calculatorText.setText("-");
                } else if (event.getSource() == divide) {
                    calculationFlags[2] = true;
                    calculatorText.setText("/");
                } else if (event.getSource() == multiply) {
                    calculationFlags[3] = true;
                    calculatorText.setText("*");
                } else if (event.getSource() == equals) {
                    calculatorText.setText(nomial1.toString());
                }
            }
        }
    }
    */

    public void initialize() {
        calculatorText.setText("0.00");
        return;
    }
}
