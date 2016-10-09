/**
 * Extends BaseStudent, maintains information relevant to Foreign students
 *
 * @author Jason Ryan
 */
public class ForeignStudent extends BaseStudent {
    private final double surchargUptoFull = -0.03 ;
    private final int surchargeAfterFull = 0;

    private final String placeOfResidence = "Foreign";

    /**
     * Constructor
     *
     * @param first String student's first name
     * @param last String student's last name
     * @param id int student's ID number
     * @param hours int number of hours student is registered for
     */
    public ForeignStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    /**
     * Getter for surchargeUptoFull
     *
     * @return double surcharge rate up to full enrollment
     */
    public double getSurchargUptoFull() {
        return surchargUptoFull;
    }

    /**
     * Getter for surchargeAfterFull
     *
     * @return double surcharge rate after full enrollment is reached
     */
    public int getSurchargeAfterFull() {
        return surchargeAfterFull;
    }

    /**
     * Getter for placeOfResidence
     *
     * @return String student's place of residence
     */
    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    /**
     * Override toString method
     *
     * @return String student information
     */
    @Override
    public String toString() {
        return super.toString() + "\nResidency: " + placeOfResidence;
    }
}
