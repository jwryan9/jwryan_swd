/**
 * Created by jasonryan on 10/3/16.
 */
public class OutOfStateStudent extends BaseStudent {
    private final String placeOfResidence = "Out of State";

    public OutOfStateStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return super.toString() + "\nResidency: " + placeOfResidence;
    }
}
