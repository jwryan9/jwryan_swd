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

    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
