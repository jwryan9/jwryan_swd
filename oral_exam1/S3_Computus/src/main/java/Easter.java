package main.java;

/**
 * Class for Easter date calculations and comparisons.
 *
 * @author Jason Ryan
 */
public class Easter implements Comparable<Easter> {
    private int month, day;

    /**
     * Easter constructor
     *
     * @param year integer for year used to generate Easter date
     */
    public Easter(int year) {
        generateDate(year);
    }

    /**
     * Generates month/day combination corresponding
     * to the date of easterin a given year.
     *
     * @param year integer for year used to generate Easter date
     */
    private void generateDate(int year) {
        int Y, a, b, c, d, e, f, g, h, i, k, L, m;

        // Perform Easter computation using the Anonymous Gregorian algorithm
        // https://en.wikipedia.org/wiki/Computus#Anonymous_Gregorian_algorithm
        Y = year;
        a = Y % 19;
        b = Y / 100;
        c = Y % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = (b - f + 1) / 3;
        h = (19 * a + b - d - g + 15) % 30;
        i = c / 4;
        k = c % 4;
        L = (32 + 2 * e + 2 * i - h - k) % 7;
        m = (a + 11 * h + 22 * L)/451;

        month = (h + L - 7 * m + 114) / 31;
        day = ((h + L - 7 * m + 114) % 31) + 1;
    }

    /**
     * Getter for Easter month
     *
     * @return integer corresponding to month of Easter object
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter for Easter day
     *
     * @return integer corresponding to day of Easter object
     */
    public int getDay() {
        return day;
    }

    /**
     * Method allows the comparison of Easter objects for sorting in TreeMap
     *
     * @param e Easter object for comparison
     * @return integer 0 if Easter dates are same, 1 if this date is later than e, -1 if this date is earlier than e
     */
    @Override
    public int compareTo(Easter e) {
        if (this.getMonth() == e.getMonth()) {
            if (this.getDay() == e.getDay())
                return 0;
            else if (this.getDay() > e.getDay())
                return 1;
            else
                return -1;
        }
        else if (this.getMonth() > e.getMonth())
            return  1;
        else
            return -1;
    }

    /**
     * Overrides default toString method
     *
     * @return String with day and month of Easter date
     */
    @Override
    public String toString() {
        String monthString;
        String easterString;

        //
        if(month == 3)
            monthString = "March";
        else if(month == 4)
            monthString = "April";
        else {
            System.out.println("Error: invalid month");
            return "";
        }

        easterString = day + " " + monthString;

        return easterString;
    }
}
