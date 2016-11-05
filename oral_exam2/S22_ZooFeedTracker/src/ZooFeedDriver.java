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

        zooAnimals.add(new Bear("bear1", "bear pen"));
        zooAnimals.add(new Bear("bear2", "bear pen"));
        zooAnimals.add(new Beaver("beaver1", "beaver pen"));
        zooAnimals.add(new Beaver("beaver2", "beaver pen"));
        zooAnimals.add(new Dolphin("dolphin1", "pool"));
        zooAnimals.add(new Dolphin("dolphin2", "pool"));
        zooAnimals.add(new Elephant("elephant1", "elephant pen"));
        zooAnimals.add(new Elephant("elephant2", "elephant pen"));
        zooAnimals.add(new Lion("lion1", "lion pen"));
        zooAnimals.add(new Lion("lion2", "lion pen"));
        zooAnimals.add(new Snake("snake1", "snake pen"));
        zooAnimals.add(new Snake("snake2", "snake pen"));

        mainMenu(kb, zooAnimals);

        kb.close();
    }

    /**
     * Displays main menu to user for operating zoo feeder system
     *
     * @param kb Scanner object used for retrieving user input
     * @param zooAnimals ArrayList of Animal objects
     */
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
                    System.out.println("\nComposite Grocery List (lbs):");
                    System.out.println(compositeGroceryList.getGroceryList());
                    break;
                case 5:
                    singleAnimalGroceries(kb, zooAnimals);
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

    /**
     * Allows user to add new animal to the zoo
     *
     * @param kb Scanner object used for retrieving user input
     * @param zooAnimals ArrayList of Animal objects
     */
    private static void addAnimal(Scanner kb, ArrayList<Animal> zooAnimals) {
        int choice;
        String location, name;

        System.out.println("Animal Type");
        System.out.println("1) Bear");
        System.out.println("2) Beaver");
        System.out.println("3) Dolphin");
        System.out.println("4) Elephant");
        System.out.println("5) Lion");
        System.out.println("6) Snake");

        choice = getSelection(kb);

        switch (choice) {
            case 1:
                System.out.print("Name: ");
                name = kb.nextLine();
                System.out.print("Animal Location: ");
                location = kb.nextLine();

                zooAnimals.add(new Bear(name, location));
                break;
            case 2:
                System.out.print("Name: ");
                name = kb.nextLine();
                System.out.print("Animal Location: ");
                location = kb.nextLine();

                zooAnimals.add(new Beaver(name, location));
                break;
            case 3:
                System.out.print("Name: ");
                name = kb.nextLine();
                System.out.print("Animal Location: ");
                location = kb.nextLine();

                zooAnimals.add(new Dolphin(name, location));
                break;
            case 4:
                System.out.print("Name: ");
                name = kb.nextLine();
                System.out.print("Animal Location: ");
                location = kb.nextLine();

                zooAnimals.add(new Elephant(name, location));
                break;
            case 5:
                System.out.print("Name: ");
                name = kb.nextLine();
                System.out.print("Animal Location: ");
                location = kb.nextLine();

                zooAnimals.add(new Lion(name, location));
                break;
            case 6:
                System.out.print("Name: ");
                name = kb.nextLine();
                System.out.print("Animal Location: ");
                location = kb.nextLine();

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
        if(choice >= 0 && choice < i) {
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

        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void singleAnimalGroceries(Scanner kb, ArrayList<Animal> zooAnimals) {
        int choice;
        ArrayList<Animal> singleAnimalList;
        GroceryList groceries = new GroceryList();

        System.out.println("Animal Type");
        System.out.println("1) Bear");
        System.out.println("2) Beaver");
        System.out.println("3) Dolphin");
        System.out.println("4) Elephant");
        System.out.println("5) Lion");
        System.out.println("6) Snake");

        choice = getSelection(kb);

        switch (choice) {
            case 1:
                singleAnimalList = getSingleAnimal(zooAnimals, "bear");
                groceries.generateList(singleAnimalList);
                System.out.println("Bear Grocery List (lbs)");
                break;
            case 2:
                singleAnimalList = getSingleAnimal(zooAnimals, "beaver");
                groceries.generateList(singleAnimalList);
                System.out.println("Beaver Grocery List (lbs)");
                break;
            case 3:
                singleAnimalList = getSingleAnimal(zooAnimals, "dolphin");
                groceries.generateList(singleAnimalList);
                System.out.println("Dolphin Grocery List (lbs)");
                break;
            case 4:
                singleAnimalList = getSingleAnimal(zooAnimals, "elephant");
                groceries.generateList(singleAnimalList);
                System.out.println("Elephant Grocery List (lbs)");
                break;
            case 5:
                singleAnimalList = getSingleAnimal(zooAnimals, "lion");
                groceries.generateList(singleAnimalList);
                System.out.println("Lion Grocery List (lbs)");
                break;
            case 6:
                singleAnimalList = getSingleAnimal(zooAnimals, "snake");
                groceries.generateList(singleAnimalList);
                System.out.println("Snake Grocery List (lbs)");
                break;
            default:
                System.out.println("Invalid choice.");

                // Ensure choice is set to -1 on invalid selection
                choice = -1;
                break;
        }

        // If user has made valid animal selection print the grocery list
        if(choice != -1) {
            System.out.println(groceries.getGroceryList());
        }
    }

    // Gets user selection from keyboard
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

    // Generates ArrayList of one animal type
    private static ArrayList<Animal> getSingleAnimal(ArrayList<Animal> zooAnimals, String animalType) {
        ArrayList<Animal> singleAnimalList = new ArrayList<>();

        for(Animal animal : zooAnimals) {
            if(animal.getAnimalType() == animalType) {
                singleAnimalList.add(animal);
            }
        }

        return singleAnimalList;
    }
}
