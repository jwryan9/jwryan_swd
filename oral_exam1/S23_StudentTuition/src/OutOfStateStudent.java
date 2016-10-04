/**
 * Created by jasonryan on 10/3/16.
 */
public class OutOfStateStudent extends BaseStudent {
    private final int discountUptoFull = 0;
    private final int discountAfterFull = 0;

    private final String placeOfResidence = "Out of State";

    public OutOfStateStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    public int getDiscountUptoFull() {
        return discountUptoFull;
    }

    public int getDiscountAfterFull() {
        return discountAfterFull;
    }

    @Override
    public String toString() {
        return super.toString() + "\nResidency: " + placeOfResidence;
    }
}
