/**
 * Created by jasonryan on 10/3/16.
 */
public class LiberalForeignGraduate extends LiberalForeignStudent {
    private final int fullLoad = 9;

    private final String studentStatus = "Graduate";

    public LiberalForeignGraduate(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return super.toString() + "Student Status: " + studentStatus;
    }
}
