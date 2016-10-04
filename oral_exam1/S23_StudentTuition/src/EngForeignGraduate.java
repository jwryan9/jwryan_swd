/**
 * Created by jasonryan on 10/3/16.
 */
public class EngForeignGraduate extends EngForeignStudent{
    private final int fullLoad = 9;
    private double tuition;

    private final String studentStatus = "Graduate";

    public EngForeignGraduate(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        tuition = tuitionOwed();
    }

    // Method to calculate tuition
    private double tuitionOwed() {
        double tuition = 0;
        int hours = this.getNumberOfRegisteredHours();

        if(hours >= 6)
            tuition += this.getFeesAndServ();

        if(hours <= fullLoad) {
            tuition = hours * getBaseClassHourTuitionRate() + hours * getSurchargUptoFull();
        } else {
            hours -= fullLoad;
            tuition += fullLoad * getBaseClassHourTuitionRate() + fullLoad * getSurchargUptoFull();
            tuition += hours * getBaseClassHourTuitionRate() + hours * getSurchargeAfterFull();
        }

            return tuition;
    }

    @Override
    public String toString() {
        return super.toString() + "Student Status: " + studentStatus;
    }
}
