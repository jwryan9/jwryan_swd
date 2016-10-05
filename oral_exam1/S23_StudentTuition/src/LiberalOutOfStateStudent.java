/**
 * Created by jasonryan on 10/3/16.
 */
public class LiberalOutOfStateStudent extends OutOfStateStudent {
    private final int feesAndServ = 400;
    private final int minHoursForFees = 3;

    private final String collegeEnrolled = "Liberal Arts";

    public LiberalOutOfStateStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    public int getFeesAndServ() {
        return feesAndServ;
    }

    public int getMinHoursForFees() {
        return minHoursForFees;
    }

    public String getCollegeEnrolled() {
        return collegeEnrolled;
    }

    @Override
    public String toString() {
        return  super.toString() + "\nCollege Enrolled: " + collegeEnrolled;
    }
}
