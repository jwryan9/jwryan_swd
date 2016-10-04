/**
 * Created by jasonryan on 10/3/16.
 */
public class IowaStudent extends BaseStudent {
    private final int discountUptoFull = 35;
    private final int discountAfterFull = 10;

    private final String placeOfResidence = "Iowa";


    public IowaStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return super.toString() + "\nResidency: " + placeOfResidence;
    }
}
