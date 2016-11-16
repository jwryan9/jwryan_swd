import java.math.BigDecimal;

/**
 * Created by Daniel on 11/11/2016.
 */
public class CalculatorModel {
    // Declare instance variables

    public BigDecimal calculate(BigDecimal nomial1, BigDecimal nomial2, boolean[] flags) {
        BigDecimal calculation = new BigDecimal(0.00);
        if(flags[2]) {
            flags[2] = false;
            calculation = nomial1.divide(nomial2);
        } else if(flags[3]) {
            flags[3] = false;
            calculation = nomial1.multiply(nomial2);
        } else if(flags[1]) {
            flags[1] = false;
            calculation = nomial1.subtract(nomial2);
        } else if(flags[0]) {
            flags[0] = false;
            calculation = nomial1.add(nomial2);
        } else if((!flags[0])&&(!flags[1])&&(!flags[2])&&(!flags[3])) {
            calculation = nomial2;
        }
        return calculation;
    }
}
