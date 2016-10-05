/**
 * Created by jasonryan on 10/3/16.
 */
public class EngIowaGraduate extends EngIowaStudent {
    private final int fullLoad = 9;
    private double tuition;

    private final String studentStatus = "Graduate";

    public EngIowaGraduate(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        updateTuition();
    }

    // Method updates tuition variable with calculated tuition
    public void updateTuition() {
        tuition = Tuition.calculateTuition(this.getNumberOfRegisteredHours(), this.getMinHoursForFees(), this.getFeesAndServ(),
                this.fullLoad, this.getDiscountUptoFull(), this.getDiscountAfterFull());
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
