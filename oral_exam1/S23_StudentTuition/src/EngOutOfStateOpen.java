/**
 * Created by jasonryan on 10/3/16.
 */
public class EngOutOfStateOpen extends EngOutOfStateStudent{
    private final int fullLoad = 3;
    private double tuition;

    private final String studentStatus = "Open";

    public EngOutOfStateOpen(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        tuition = Tuition.calculateTuition(hours, getMinHoursForFees(), getFeesAndServ(), fullLoad,
                getBaseClassHourTuitionRate(), getDiscountUptoFull(), getDiscountAfterFull());
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
