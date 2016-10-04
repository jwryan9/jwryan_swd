/**
 * Created by jasonryan on 10/3/16.
 */
public class LiberalOutOfStateGraduate extends LiberalOutOfStateStudent {
    private final int fullLoad = 9;
    private double tuition;

    private final String studentStatus = "Graduate";

    public LiberalOutOfStateGraduate(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        tuition = Tuition.calculateTuition(hours, getMinHoursForFees(), getFeesAndServ(), fullLoad,
                getBaseClassHourTuitionRate(), getDiscountUptoFull(), getDiscountAfterFull());
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
