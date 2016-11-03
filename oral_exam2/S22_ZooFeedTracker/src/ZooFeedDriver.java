import java.util.*;

/**
 * Driver program to demonstrate the functionality of ZooFeedTracker
 *
 * @author Jason Ryan
 */
public class ZooFeedDriver {

    private static GroceryList compositeGroceryList;

    public static void main(String[] args) {
        ArrayList<Animal> zooAnimals = new ArrayList<>();
        Scanner kb = new Scanner(System.in);

        mainMenu(kb, zooAnimals);

        kb.close();
    }

    private static void mainMenu(Scanner kb, ArrayList<Animal> zooAnimals) {
        int choice;

        do {
            System.out.println("\nMain menu");
            System.out.println("1) Display animals.");
            System.out.println("2) Add animal.");
            System.out.println("3) Add feeding.");
            System.out.println("4) Composite grocery list.");
            System.out.println("5) Animal grocery list.");
            System.out.println("6) Reset feedings.");
            System.out.println("7) Exit.");
            System.out.println("Enter choice");

            choice = getSelection(kb);

            switch (choice) {
                case 1:
                    for (Animal animal : zooAnimals) {
                        System.out.println(animal + "\n");
                    }
                    break;
                case 2:
                    addAnimal(kb, zooAnimals);
                    break;
                case 3:
                    addFeeding(kb, zooAnimals);
                    break;
                case 4:
                    compositeGroceryList = new GroceryList();
                    compositeGroceryList.generateList(zooAnimals);
                    System.out.println(compositeGroceryList.getGroceryList());
                    break;
                case 5:
                    break;
                case 6:
                    for (Animal animal : zooAnimals) {
                        animal.resetFeedingTotals();
                    }
                    break;
                case 7:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice");
            }
        } while(choice != 7);
    }

    private static void addAnimal(Scanner kb, ArrayList<Animal> zooAnimals) {
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

    private static void addFeeding(Scanner kb, ArrayList<Animal> zooAnimals) {
        int i = 0, choice, amount = 0;
        String foodType;

        System.out.println("\nSelect an animal.");
        for(Animal animal : zooAnimals) {
            System.out.println(i + ") " + animal.getName());
            i++;
        }

        choice = getSelection(kb);

        // Validate animal selection
        if(choice >= 0 && choice <= i) {
            Animal animalToFeed = zooAnimals.get(choice);
            System.out.println(animalToFeed.getAnimalType() + "s eat: " + animalToFeed.getFoodTypes());

            System.out.println("Enter food type:");
            foodType = kb.nextLine();
            System.out.println("Enter amount (lbs):");
            try {
                amount = kb.nextInt();

                // Clear line
                kb.nextLine();

                // Validate foodType for feeding
                if(animalToFeed.getFoodTypes().contains(foodType.toUpperCase())) {
                    animalToFeed.addFeeding(foodType, amount);
                } else {
                    System.out.println("Invalid food type.");
                    amount = 0;
                }
            } catch (InputMismatchException ex) {
                // Clear line
                kb.nextLine();

                amount = 0;

                System.out.println("Invalid amount");
            } finally {
                System.out.println(animalToFeed.getName() + " has been fed " + amount + " lbs of " + foodType + ".\n");
            }

        }
    }

    private static int getSelection(Scanner kb) {
        int choice;

        try {
            choice = kb.nextInt();

            // Clear line
            kb.nextLine();
        } catch (InputMismatchException ex) {
            // Clear line
            kb.nextLine();

            choice = -1;
        }

        return choice;
    }
}
