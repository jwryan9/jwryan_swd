/**
 * Created by jasonryan on 10/3/16.
 */
public class BaseStudent {
    int baseClassHourTuitionRate = 350;
    String firstName, lastName;
    int studentID, numberOfRegisteredHours;

    // Constructor
    public BaseStudent(String first, String last, int id, int hours) {
        firstName = first;
        lastName = last;
        studentID = id;
        numberOfRegisteredHours = hours;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + "/nLast Name: " + lastName + "\nStudent ID: " + studentID + "\nHours Registered: " + numberOfRegisteredHours;
    }
}
