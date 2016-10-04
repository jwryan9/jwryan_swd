/**
 * Created by jasonryan on 10/3/16.
 */
public class EngForeignGraduate extends EngForeignStudent{
    private final int fullLoad = 9;
    private double tuition;

    private final String studentStatus = "Graduate";

    public EngForeignGraduate(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        //tuition = tuitionOwed();
        tuition = Tuition.calculateTuition(hours, this.getMinHoursForFees(), this.getFeesAndServ(), fullLoad,
                this.getBaseClassHourTuitionRate(), this.getSurchargUptoFull(), this.getSurchargeAfterFull());
    }

    /*
    // Method to calculate tuition
    private double tuitionOwed() {
        double tuition = 0;
        int hours = this.getNumberOfRegisteredHours();

        if(hours >= this.getMinHoursForFees())
            tuition += this.getFeesAndServ();

        if(hours <= fullLoad) {
            tuition += hours * getBaseClassHourTuitionRate() * (1 + getSurchargUptoFull());
        } else {
            hours -= fullLoad;
            tuition += fullLoad * getBaseClassHourTuitionRate() * (1 + getSurchargUptoFull());
            tuition += hours * getBaseClassHourTuitionRate() * (1 + getSurchargeAfterFull());
        }

            return tuition;
    }
    */

    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
