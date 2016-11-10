import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for representing snakes in a zoo. Extends Animal.
 *
 * @author Jason Ryan
 */
public class Snake extends Animal {

    private String animalType = "snake";
    private HashMap<String, Integer> feedings;

    /**
     * Constructor for snake objects
     *
     * @param name name to assign snake
     * @param location snake's location in the zoo
     */
    public Snake(String name, String location) {
        super(name, location);
        feedings = new HashMap<>();
        feedings.put("MICE", 0);
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
     * Method for getting food types snakes can eat
     *
     * @return list of food types
     */
    @Override
    public List<String> getFoodTypes() {
        return new ArrayList<>(feedings.keySet());
    }

    /**
     * Method for feeding the snake
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
     * Method for retrieving the amount of food snake has been fed
     *
     * @return HashMap of food types and amount in lbs
     */
    @Override
    public HashMap<String, Integer> getFeedingTotals() {
        return feedings;
    }

    /**
     * Resets the amount of food snake has eaten to zero
     */
    @Override
    public void resetFeedingTotals() {
        feedings.put("MICE", 0);
    }
}
