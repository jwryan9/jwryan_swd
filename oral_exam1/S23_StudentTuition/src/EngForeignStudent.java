/**
 * Created by jasonryan on 10/3/16.
 */
public class EngForeignStudent extends ForeignStudent {
    private final int feesAndServ = 200;
    private final int minHoursForFees = 6;

    private final String collegeEnrolled = "Engineering";

    public EngForeignStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    public int getMinHoursForFees() {
        return minHoursForFees;
    }

    public int getFeesAndServ() {
        return feesAndServ;
    }

    @Override
    public String toString() {
        return  super.toString() + "\nCollege Enrolled: " + collegeEnrolled;
    }
}
