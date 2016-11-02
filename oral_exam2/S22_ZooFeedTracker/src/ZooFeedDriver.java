import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Driver program to demonstrate the functionality of ZooFeedTracker
 *
 * @author Jason Ryan
 */
public class ZooFeedDriver {

    public static void main(String[] args) {

        // Instantiate animals
        Animal beaver1 = new Beaver("Senor Bucktooth", "Beaver Pen");
        Animal lion1 = new Lion("Leo", "Lion Habitat");
        Animal elephant1 = new Elephant("Sir Trunksalot", "Watering Hole");
        Animal dolphin1 = new Dolphin("Finny", "Pool");

        ArrayList<Animal> zooAnimals = new ArrayList<>();

        zooAnimals.add(beaver1);
        zooAnimals.add(lion1);
        zooAnimals.add(elephant1);
        zooAnimals.add(dolphin1);

        Scanner kb = new Scanner(System.in);

        mainMenu(kb, zooAnimals);

        kb.close();
    }

    private static void mainMenu(Scanner kb, ArrayList zooAnimals) {
        int choice;

        do {
            System.out.println("Welcome to ZooFeeder 3000");
            System.out.println("1) Display animals.");
            System.out.println("2) Add animal.");
            System.out.println("3) Add feeding.");
            System.out.println("4) Composite grocery list.");
            System.out.println("5) Animal grocery list.");
            System.out.println("6) Reset feedings.");
            System.out.println("7) Exit.");
            System.out.println("Enter choice");

            try {
                choice = kb.nextInt();

                // Clear line
                kb.nextLine();
            } catch (InputMismatchException ex) {
                // Clear line
                kb.nextLine();

                choice = -1;
            }

            switch (choice) {
                case 1:
                    for (Object animal : zooAnimals) {
                        System.out.println(animal + "\n");
                    }
                    break;
                case 2:
                    addAnimal(kb, zooAnimals);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 7);
    }

    private static void addAnimal(Scanner kb, ArrayList zooAnimals) {
        int choice;
        String location = "", name = "";

        System.out.println("Animal Type");
        System.out.println("1) Bear");
        System.out.println("2) Beaver");
        System.out.println("3) Dolphin");
        System.out.println("4) Elephant");
        System.out.println("5) Lion");
        System.out.println("6) Snake");

        try {
            choice = kb.nextInt();

            // Skip rest of line
            kb.nextLine();

            System.out.print("Name: ");
            name = kb.nextLine();

            System.out.print("Animal Location: ");
            location = kb.nextLine();

        } catch (InputMismatchException ex) {
            choice = -1;
        }

        switch (choice) {
            case 1:
                zooAnimals.add(new Bear(name, location));
                break;
            case 2:
                zooAnimals.add(new Beaver(name, location));
                break;
            case 3:
                zooAnimals.add(new Dolphin(name, location));
                break;
            case 4:
                zooAnimals.add(new Elephant(name, location));
                break;
            case 5:
                zooAnimals.add(new Lion(name, location));
                break;
            case 6:
                zooAnimals.add(new Snake(name, location));
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
