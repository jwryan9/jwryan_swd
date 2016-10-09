/**
 * Generic base student class containing information relevent to all students
 *
 * @author Jason Ryan
 */
public class BaseStudent {
    private final String firstName, lastName;
    private int studentID, numberOfRegisteredHours;

    /**
     * Constructor
     *
     * @param first String student's first name
     * @param last String student's last name
     * @param id int student's id number
     * @param hours int number of hours student is registered for
     */
    public BaseStudent(String first, String last, int id, int hours) {
        firstName = first;
        lastName = last;
        studentID = id;
        numberOfRegisteredHours = hours;
    }

    /**
     * Getter for firstName
     *
     * @return String student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for lastName
     *
     * @return String student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for studentID
     *
     * @return int student's id number
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Setter for studentID
     * @param studentID int new student ID number
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Getter for numberOfRegisteredHours
     *
     * @return int number of hours student is registered for
     */
    public int getNumberOfRegisteredHours() {
        return numberOfRegisteredHours;
    }

    /**
     * Setter for numberOfRegisteredHours
     *
     * @param numberOfRegisteredHours int new number of hours student is registered for
     */
    public void setNumberOfRegisteredHours(int numberOfRegisteredHours) {
        this.numberOfRegisteredHours = numberOfRegisteredHours;
    }

    /**
     * Override toString method
     *
     * @return String student information
     */
    @Override
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nStudent ID: " + studentID + "\nHours Registered: " + numberOfRegisteredHours;
    }
}
