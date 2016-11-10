import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class makes grocery list for zoo dietitian to follow when shopping for
 * food based on past animal feedings
 *
 * @author Jason Ryan
 */
public class GroceryList {

    HashMap<String, Integer> groceryList;

    /**
     * Constructor for GroceryList object
     */
    public GroceryList() {
        groceryList = new HashMap<>();

        groceryList.put("BASS", 0);
        groceryList.put("BERRIES", 0);
        groceryList.put("HAY", 0);
        groceryList.put("MICE", 0);
        groceryList.put("PEANUTS", 0);
        groceryList.put("SALMON", 0);
        groceryList.put("SHRIMP", 0);
        groceryList.put("TROUT", 0);
        groceryList.put("ZEBRA", 0);
    }

    /**
     * Method generates grocery list based on list of zoo animals
     *
     * @param zooAnimals list of animals to analyze feedings when generating list
     */
    public void generateList(ArrayList<Animal> zooAnimals) {
        HashMap<String, Integer> animalFeedings;
        List<String> animalFoodTypes;

        for(Animal animal : zooAnimals) {
            animalFeedings = animal.getFeedingTotals();
            animalFoodTypes = animal.getFoodTypes();
            for(String foodType : animalFoodTypes) {
                groceryList.put(foodType, groceryList.get(foodType) + animalFeedings.get(foodType));
            }
        }
    }

    /**
     * Method for retrieving the amount of food the zoo dietitian should purchase
     *
     * @return HashMap of food types and amount in lbs
     */
    public HashMap<String, Integer> getGroceryList() {
        return groceryList;
    }
}
