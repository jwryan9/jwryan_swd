/**
 * Created by jasonryan on 10/3/16.
 */
public class ForeignStudent extends BaseStudent {
    private final double surchargUptoFull = -0.03 ;
    private final int surchargeAfterFull = 0;

    private final String placeOfResidence = "Foreign";

    public ForeignStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    public double getSurchargUptoFull() {
        return surchargUptoFull;
    }

    public int getSurchargeAfterFull() {
        return surchargeAfterFull;
    }

    @Override
    public String toString() {
        return super.toString() + "\nResidency: " + placeOfResidence;
    }
}
