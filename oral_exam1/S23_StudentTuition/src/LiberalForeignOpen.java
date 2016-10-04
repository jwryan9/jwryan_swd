/**
 * Created by jasonryan on 10/3/16.
 */
public class LiberalForeignOpen extends LiberalForeignStudent {
    private final int fullLoad = 3;

    private final String studentStatus = "Open";

    public LiberalForeignOpen(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return super.toString() + "Student Status: " + studentStatus;
    }
}