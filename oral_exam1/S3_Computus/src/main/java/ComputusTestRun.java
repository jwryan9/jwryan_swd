package main.java;
import java.util.Scanner;

/**
 * Created by jasonryan on 9/1/16.
 */

public class ComputusTestRun {
    public static void main(String[] args) {
        int year, selection = 0;
        Scanner kb = new Scanner(System.in);

        while (selection != 3) {

            System.out.println("\n1. Enter year for computation.\n2. Display counts of dates in cycle.\n3. Exit program.\nSelection:");
            try {
                selection = kb.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("\nEnter year for calculation");
                        try {
                            year = kb.nextInt();
                        } catch(Exception ex) {
                            System.out.println("Invalid Input.");
                            kb.nextLine();
                            break;
                        }

                        if(year < 1) {
                            System.out.println("Year must be greater than 0");
                            break;
                        }

                        Easter userEaster = new Easter(year);
                        System.out.println(userEaster + " " + year);
                        break;

                    case 2:
                        ComputusCycle.displayCycleCounts();
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid Input.");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Invalid Input.");
                kb.nextLine();
            }
        }

    }
}
