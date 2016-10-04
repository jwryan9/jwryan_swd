/**
 * Created by jasonryan on 10/3/16.
 */
public class EngIowaUndergrad extends EngIowaStudent {
    private final int fullLoad = 15;

    private final String studentStatus = "Undergrad";

    public EngIowaUndergrad(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return super.toString() + "Student Status: " + studentStatus;
    }
}
