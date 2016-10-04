/**
 * Created by jasonryan on 10/3/16.
 */
public class EngForeignOpen extends EngForeignStudent {
    private final int fullLoad = 3;
    private double tuition;

    private final String studentStatus = "Open";

    public EngForeignOpen(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        tuition = Tuition.calculateTuition(hours, getMinHoursForFees(), getFeesAndServ(), fullLoad,
                getBaseClassHourTuitionRate(), getSurchargUptoFull(), getSurchargeAfterFull());
    }

    @Override
    public String toString() {
        return super.toString() + "Student Status: " + studentStatus;
    }
}