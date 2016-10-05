/**
 * Created by jasonryan on 10/3/16.
 */
public class EngForeignGraduate extends EngForeignStudent{
    private final int fullLoad = 9;
    private double tuition;

    private final String studentStatus = "Graduate";

    public EngForeignGraduate(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        updateTuition();
    }

    // Method updates tuition variable with calculated tuition
    public void updateTuition() {
        tuition = Tuition.calculateTuition(this.getNumberOfRegisteredHours(), this.getMinHoursForFees(), this.getFeesAndServ(),
                this.fullLoad, this.getSurchargUptoFull(), this.getSurchargeAfterFull());
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
