package test.java;

import main.java.Easter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class for JUnit testing of Computus assignment, required for completion of hard
 * Source of known Easter dates: http://tlarsen2.tripod.com/thomaslarsen/easterdates.html
 *
 * @author Jason Ryan
 */
public class EasterTest {

    private final int START_YEAR = 2000;

    private BufferedReader reader;

    /**
     * Method attempts to open file in a BufferedReader
     *
     * @param filename String containing filepath/name to be opened
     */
    private void openFile(String filename) {
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
        }
    }

    /**
     * Test's Easter's toString method against file of known Easter dates
     */
    @org.junit.Test
    public void toStringTest() {
        int currentYear = START_YEAR;

        final String easterDatesFile = "src/test/java/EasterDates2000_2024.txt";
        String eString, line;

        openFile(easterDatesFile);

        // Catch IOException thrown by readLine() or close()
        try {
            // Loop through lines of file to check if calculated Easter dates match known dates
            while((line = reader.readLine()) != null) {
                Easter e = new Easter(currentYear);
                eString = e.toString() + " " + currentYear;
                org.junit.Assert.assertEquals(line, eString);
                currentYear++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}