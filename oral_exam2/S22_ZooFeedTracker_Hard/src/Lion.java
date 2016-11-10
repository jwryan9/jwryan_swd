import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for representing lions in a zoo. Extends Animal.
 *
 * @author Jason Ryan
 */
public class Lion extends Animal {

    private String animalType = "Lion";
    private HashMap<String, Integer> feedings;

    /**
     * Constructor for lion objects
     *
     * @param name name to assign lion
     * @param location lion's location in the zoo
     */
    public Lion(String name, String location) {
        super(name, location);
        feedings = new HashMap<>();
        feedings.put("ZEBRA", 0);
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
     * Method for getting food types lions can eat
     *
     * @return list of food types
     */
    @Override
    public List<String> getFoodTypes() {
        return new ArrayList<>(feedings.keySet());
    }

    /**
     * Method for feeding the lion
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
     * Method for retrieving the amount of food lion has been fed
     *
     * @return HashMap of food types and amount in lbs
     */
    @Override
    public HashMap<String, Integer> getFeedingTotals() {
        return feedings;
    }

    /**
     * Resets the amount of food lion has eaten to zero
     */
    @Override
    public void resetFeedingTotals() {
        feedings.put("ZEBRA", 0);
    }

}
