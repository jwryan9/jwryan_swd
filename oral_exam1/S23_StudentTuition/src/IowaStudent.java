/**
 * Extends BaseStudent, maintains information relevant to Iowa students
 *
 * @author Jason Ryan
 */
public class IowaStudent extends BaseStudent {
    private final double discountUptoFull = .35;
    private final double discountAfterFull = .10;

    private final String placeOfResidence = "Iowa";


    /**
     * Constructor
     *
     * @param first String student's first name
     * @param last String student's last name
     * @param id int student's ID number
     * @param hours int number of hours student is registered for
     */
    public IowaStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    /**
     * Getter for discountUptoFull
     *
     * @return double discount rate up to full enrollment
     */
    public double getDiscountUptoFull() {
        return discountUptoFull;
    }

    /**
     * Getter for discountRateAfterFull
     *
     * @return double discount rate after full enrollment is reached
     */
    public double getDiscountAfterFull() {
        return discountAfterFull;
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
