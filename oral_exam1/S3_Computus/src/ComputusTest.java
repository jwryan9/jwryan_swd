/**
 * Created by jasonryan on 9/1/16.
 */

import java.util.Scanner;

public class ComputusTest {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter year to start Easter calculation (-1 to exit): ");
        int year = kb.nextInt();
        int newYear = year;

        Easter e = new Easter(newYear);
        System.out.println(e.getMonth() + " " + e.getDay() + " " + year);

    }
}
