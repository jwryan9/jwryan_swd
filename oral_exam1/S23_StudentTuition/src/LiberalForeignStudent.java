/**
 * Created by jasonryan on 10/3/16.
 */
public class LiberalForeignStudent extends ForeignStudent {
    private final int feesAndServ = 400;

    private final String collegeEnrolled = "Liberal Arts";

    public LiberalForeignStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return  super.toString() + "\nCollege Enrolled: " + collegeEnrolled;
    }
}
