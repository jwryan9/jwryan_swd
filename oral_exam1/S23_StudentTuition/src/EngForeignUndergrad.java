/**
 * Created by jasonryan on 10/3/16.
 */
public class EngForeignUndergrad extends EngForeignStudent {
    private final int fullLoad = 15;

    private final String studentStatus = "Undergrad";

    public EngForeignUndergrad(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return super.toString() + "Student Status: " + studentStatus;
    }
}
