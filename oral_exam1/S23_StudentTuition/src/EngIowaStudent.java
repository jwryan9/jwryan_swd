/**
 * Created by jasonryan on 10/3/16.
 */
public class EngIowaStudent extends IowaStudent {
    private final int feesAndServ = 200;
    private final int minHoursForFees = 6;

    private final String collegeEnrolled = "Engineering";

    public EngIowaStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    public int getFeesAndServ() {
        return feesAndServ;
    }

    @Override
    public String toString() {
        return  super.toString() + "\nCollege Enrolled: " + collegeEnrolled;
    }
}
