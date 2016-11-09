import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for representing elephants in a zoo. Extends Animal.
 *
 * @author Jason Ryan
 */
public class Elephant extends Animal {

    private String animalType = "elephant";
    private HashMap<String, Integer> feedings;

    /**
     * Constructor for elephant objects
     *
     * @param name name to assign elephant
     * @param location elephant's location in the zoo
     */
    public Elephant(String name, String location) {
        super(name, location);
        feedings = new HashMap<>();
        feedings.put("HAY", 0);
        feedings.put("PEANUTS", 0);
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
     * Method for getting food types elephants can eat
     *
     * @return list of food types
     */
    @Override
    public List<String> getFoodTypes() {
        return new ArrayList<>(feedings.keySet());
    }

    /**
     * Method for feeding the elephant
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
     * Method for retrieving the amount of food an elephant has been fed
     *
     * @return HashMap of food types and amount in lbs
     */
    @Override
    public HashMap<String, Integer> getFeedingTotals() {
        return feedings;
    }

    /**
     * Resets the amount of food elephant has eaten to zero
     */
    @Override
    public void resetFeedingTotals() {
        feedings.put("HAY", 0);
        feedings.put("PEANUTS", 0);
    }

}
