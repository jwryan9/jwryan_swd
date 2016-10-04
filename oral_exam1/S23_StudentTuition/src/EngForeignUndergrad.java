/**
 * Created by jasonryan on 10/3/16.
 */
public class EngForeignUndergrad extends EngForeignStudent {
    private final int fullLoad = 15;
    private double tuition;

    private final String studentStatus = "Undergrad";

    public EngForeignUndergrad(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        tuition = Tuition.calculateTuition(hours, getMinHoursForFees(), getFeesAndServ(), fullLoad,
                getBaseClassHourTuitionRate(), getSurchargUptoFull(), getSurchargeAfterFull());
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
