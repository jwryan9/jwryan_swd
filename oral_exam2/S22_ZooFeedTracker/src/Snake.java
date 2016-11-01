import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jason Ryan
 */
public class Snake extends Animal {

    private String animalType = "snake";
    private HashMap<String, Integer> feedings;

    public Snake(String name, String location) {
        super(name, location);
        feedings = new HashMap<>();
        feedings.put("MICE", 0);
    }

    @Override
    public String getAnimalType() {
        return animalType;
    }

    @Override
    public List<String> getFoodTypes() {
        return new ArrayList<>(feedings.keySet());
    }

    @Override
    public void addFeeding(String type, int amount) {
        String foodType = type.toUpperCase();
        if(feedings.containsKey(foodType)) {
            feedings.put(foodType, feedings.get(foodType) + amount);
        } else {
            System.out.println("Invalid food type.");
        }
    }

    @Override
    public Map<String, Integer> getFeedingTotals() {
        return feedings;
    }
}