/**
 * Created by jasonryan on 10/3/16.
 */
public class EngOutOfStateGraduate extends EngOutOfStateStudent {
    private final int fullLoad = 9;

    private final String studentStatus = "Graduate";

    public EngOutOfStateGraduate(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return super.toString() + "Student Status: " + studentStatus;
    }
}
