/**
 * Extends EngForeignStudent, maintains information relevant to Foreign Engineering Graduate students
 *
 * @author Jason Ryan
 */
public class EngForeignGraduate extends EngForeignStudent{
    private final int fullLoad = 9;
    private double tuition;

    private final String studentStatus = "Graduate";

    /**
     * Constructor
     *
     * @param first String student's first name
     * @param last String student's last name
     * @param id int student's ID number
     * @param hours int number of hours student is registered for
     */
    public EngForeignGraduate(String first, String last, int id, int hours) {
        super(first, last, id, hours);
        updateTuition();
    }

    /**
     * Updates tuition owed with calculated tuition
     */
    public void updateTuition() {
        tuition = Tuition.calculateTuition(this.getNumberOfRegisteredHours(), this.getMinHoursForFees(), this.getFeesAndServ(),
                this.fullLoad, this.getSurchargUptoFull(), this.getSurchargeAfterFull());
    }

    /**
     * Getter for studentStatus
     *
     * @return String student status (e.g. Undergrad, Graduate, Open)
     */
    public String getStudentStatus() {
        return studentStatus;
    }

    /**
     * Override toString method
     *
     * @return String student information
     */
    @Override
    public String toString() {
        return super.toString() + "\nStudent Status: " + studentStatus + "\nTuition Owed: $" + String.format("%.2f\n", tuition);
    }
}
