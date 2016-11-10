import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for representing bears in a zoo. Extends Animal.
 *
 * @author Jason Ryan
 */
public class Bear extends Animal {

    private String animalType = "bear";
    private HashMap<String, Integer> feedings;

    /**
     * Constructor for Bear objects
     *
     * @param name name to assign bear object
     * @param location bear's location in the zoo
     */
    public Bear(String name, String location) {
        super(name, location);
        feedings = new HashMap<>();
        feedings.put("SALMON", 0);
        feedings.put("TROUT", 0);
        feedings.put("BERRIES", 0);
    }

    /**
     * Method for getting the type of animal
     *
     * @return animal type
     */
    @Override
    public String getAnimalType() {
        return animalType;
    }

    /**
     * Method for getting food types bears can eat
     *
     * @return list of food types
     */
    @Override
    public List<String> getFoodTypes() {
        return new ArrayList<>(feedings.keySet());
    }

    /**
     * Method for feeding the bear
     *
     * @param type food type
     * @param amount lbs of food to feed
     */
    @Override
    public void addFeeding(String type, int amount) {
        String foodType = type.toUpperCase();
        if(feedings.containsKey(foodType)) {
            feedings.put(foodType, feedings.get(foodType) + amount);
        }
    }

    /**
     * Method for retrieving the amount of food a bear has been fed
     *
     * @return HashMap of food types and amount in lbs
     */
    @Override
    public HashMap<String, Integer> getFeedingTotals() {
        return feedings;
    }

    /**
     * Resets the amount of food bear has eaten to zero
     */
    @Override
    public void resetFeedingTotals() {
        feedings.put("SALMON", 0);
        feedings.put("TROUT", 0);
        feedings.put("BERRIES", 0);
    }
}
