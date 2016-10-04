/**
 * Created by jasonryan on 10/3/16.
 */
public class ForeignStudent extends BaseStudent {
    private final int surchargUptoFull = 3;
    private final int surchargeAfterFull = 0;

    private final String placeOfResidence = "Foreign";

    public ForeignStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    @Override
    public String toString() {
        return super.toString() + "\nResidency: " + placeOfResidence;
    }
}
