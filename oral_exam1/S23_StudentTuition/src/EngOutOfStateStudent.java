/**
 * Created by jasonryan on 10/3/16.
 */
public class EngOutOfStateStudent extends OutOfStateStudent {
    private final int feesAndServ = 200;

    private final String collegeEnrolled = "Engineering";

    public EngOutOfStateStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return  super.toString() + "\nCollege Enrolled: " + collegeEnrolled;
    }
}
