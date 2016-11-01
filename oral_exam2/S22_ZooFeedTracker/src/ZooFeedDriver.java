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

        // Add animals to array for storage
        Animal[] zooAnimals = new Animal[4];
        zooAnimals[0] = beaver1;
        zooAnimals[1] = lion1;
        zooAnimals[2] = elephant1;
        zooAnimals[3] = dolphin1;

        for(Animal animal : zooAnimals) {
            System.out.println(animal + "\n");
        }

    }
}
