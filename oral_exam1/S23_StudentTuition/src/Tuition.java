/**
 * Class used for calculating student tuition
 */
public class Tuition {
    private static int baseClassHourTuitionRate = 350;

    // Method to calculate tuition

    /**
     * Static method to calculate student tuition
     *
     * @param hours int number of hours student is registered for
     * @param minHoursForFees int minimum number of hours required by the college for fees and services to be applied
     * @param fees int cost of fees
     * @param fullLoad int number of hours that constitues full load for student type
     * @param surchargeDiscountUptoFull double surcharge or discount to be applied before full time is reached
     * @param surchargeDiscountAfterFull double surcharge or discount to be applied after full time is reached
     * @return double tuition owed
     */
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

    /**
     * Getter for baseClassHourTuitionRate
     *
     * @return int baseClassHourTuitionRate
     */
    public static int getBaseClassHourTuitionRate() {
        return baseClassHourTuitionRate;
    }

    /**
     * Setter for baseClassHourTuitionRate
     *
     * @param tuitionRate int new baseClassHourTuitionRate
     */
    public static void setBaseClassHourTuitionRate(int tuitionRate) {
        baseClassHourTuitionRate = tuitionRate;
    }
}
