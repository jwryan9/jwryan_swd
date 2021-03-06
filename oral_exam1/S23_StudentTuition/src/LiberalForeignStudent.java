/**
 * Extends ForeignStudent, maintains information relevant to Foreign Liberal Arts students
 *
 * @author Jason Ryan
 */
public class LiberalForeignStudent extends ForeignStudent {
    private final int feesAndServ = 400;
    private final int minHoursForFees = 3;

    private final String collegeEnrolled = "Liberal Arts";

    /**
     * Constructor
     *
     * @param first String student's first name
     * @param last String student's last name
     * @param id int student's ID number
     * @param hours int number of hours student is registered for
     */
    public LiberalForeignStudent(String first, String last, int id, int hours) {
        super(first, last, id, hours);
    }

    /**
     * Getter for feesAndServ
     *
     * @return int cost of fees and services
     */
    public int getFeesAndServ() {
        return feesAndServ;
    }

    /**
     * Getter for minHoursForFees
     *
     * @return int number of hours needed for fees to be applied
     */
    public int getMinHoursForFees() {
        return minHoursForFees;
    }

    /**
     * Getter for collegeEnrolled
     *
     * @return String college student is enrolled in
     */
    public String getCollegeEnrolled() {
        return collegeEnrolled;
    }

    /**
     * Override toString method
     *
     * @return String student information
     */
    @Override
    public String toString() {
        return  super.toString() + "\nCollege Enrolled: " + collegeEnrolled;
    }
}
