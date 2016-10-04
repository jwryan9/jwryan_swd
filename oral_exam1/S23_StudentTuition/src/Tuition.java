/**
 * Created by jasonryan on 10/4/16.
 */
public class Tuition {

    // Method to calculate tuition
    public static double calculateTuition(int hours, int minHoursForFees, int fees, int fullLoad,
                                          int baseTuitionRate, double surchargeDiscountUptoFull,
                                          double surchargeDiscountAfterFull) {
        double tuition = 0;

        if(hours >= minHoursForFees)
            tuition += fees;

        if(hours <= fullLoad) {
            tuition += hours * baseTuitionRate * (1 - surchargeDiscountUptoFull);
        } else {
            hours -= fullLoad;
            tuition += fullLoad * baseTuitionRate * (1 - surchargeDiscountUptoFull);
            tuition += hours * baseTuitionRate * (1 - surchargeDiscountAfterFull);
        }

        return tuition;
    }
}
