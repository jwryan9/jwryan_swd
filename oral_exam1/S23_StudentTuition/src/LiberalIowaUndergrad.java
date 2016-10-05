/**
 * Created by jasonryan on 10/3/16.
 */
public class LiberalIowaUndergrad extends LiberalIowaStudent {
    private final int fullLoad = 15;
    private double tuition;

    private final String studentStatus = "Undergrad";

    public LiberalIowaUndergrad(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        updateTuition();
    }

    // Method updates tuition variable with calculated tuition
    public void updateTuition() {
        tuition = Tuition.calculateTuition(this.getNumberOfRegisteredHours(), this.getMinHoursForFees(), this.getFeesAndServ(),
                this.fullLoad, this.getDiscountUptoFull(), this.getDiscountAfterFull());
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
