/**
 * Created by jasonryan on 10/3/16.
 */
public class BaseStudent {
    private int baseClassHourTuitionRate = 350;
    private String firstName, lastName;
    private int studentID, numberOfRegisteredHours;

    // Constructor
    public BaseStudent(String first, String last, int id, int hours) {
        firstName = first;
        lastName = last;
        studentID = id;
        numberOfRegisteredHours = hours;
    }

    public int getBaseClassHourTuitionRate() {
        return baseClassHourTuitionRate;
    }

    public void setBaseClassHourTuitionRate(int baseClassHourTuitionRate) {
        this.baseClassHourTuitionRate = baseClassHourTuitionRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getNumberOfRegisteredHours() {
        return numberOfRegisteredHours;
    }

    public void setNumberOfRegisteredHours(int numberOfRegisteredHours) {
        this.numberOfRegisteredHours = numberOfRegisteredHours;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + "/nLast Name: " + lastName + "\nStudent ID: " + studentID + "\nHours Registered: " + numberOfRegisteredHours;
    }
}
