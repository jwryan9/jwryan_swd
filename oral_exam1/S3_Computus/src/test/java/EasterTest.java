package test.java;

import main.java.Easter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

import junit.framework.*;
import org.testng.reporters.Buffer;

/**
 * Created by jasonryan on 9/6/16.
 */
public class EasterTest {

    private final int START_YEAR = 2000;
    private final int END_YEAR = 2024;
    private String easterDatesFile = "EasterDates2000_2024.txt"; // Source of dates: http://tlarsen2.tripod.com/thomaslarsen/easterdates.html

    BufferedReader reader;

    private void openFile(String filename) {
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
        }
    }

    @Test
    public void getString() throws Exception {
        int currentYear = START_YEAR;

        String eString, line;
        openFile(easterDatesFile);

        // Loop through lines of file to check if calculated Easter dates match known dates
        while((line = reader.readLine()) != null) {
            Easter e = new Easter(currentYear);
            eString = e.toString() + " " + currentYear;
            org.junit.Assert.assertEquals(line, eString);
            currentYear++;
        }

        reader.close();
    }

}