/**
 * Created by jasonryan on 10/4/16.
 */
public class Tuition {
    private static int baseClassHourTuitionRate = 350;

    // Method to calculate tuition
    public static double calculateTuition(int hours, int minHoursForFees, int fees, int fullLoad,
                                          double surchargeDiscountUptoFull,
                                          double surchargeDiscountAfterFull) {
        double tuition = 0;

        if(hours >= minHoursForFees)
            tuition += fees;

        if(hours <= fullLoad) {
            tuition += hours * baseClassHourTuitionRate * (1 - surchargeDiscountUptoFull);
        } else {
            hours -= fullLoad;
            tuition += fullLoad * baseClassHourTuitionRate * (1 - surchargeDiscountUptoFull);
            tuition += hours * baseClassHourTuitionRate * (1 - surchargeDiscountAfterFull);
        }

        return tuition;
    }

    public static int getBaseClassHourTuitionRate() {
        return baseClassHourTuitionRate;
    }

    public static void setBaseClassHourTuitionRate(int tuitionRate) {
        baseClassHourTuitionRate = tuitionRate;
    }
}
