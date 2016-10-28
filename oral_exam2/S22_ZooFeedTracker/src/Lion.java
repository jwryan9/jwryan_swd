import java.util.Map;

/**
 *
 * @author Jason Ryan
 */
public class Lion extends Animal {

    //private enum FoodTypes {ZEBRA}

    Map<FoodTypes, Integer> feedings;
    private String animalType = "Lion";
    private FoodTypes foodTypes;

    public Lion(String name, String location) {
        super(name, location);
    }

    @Override
    public String getAnimalType() {
        return animalType;
    }

    @Override
    public Animal.FoodTypes getFoodTypes() {
        return null;
    }

    @Override
    public void addFeeding(FoodTypes type, int amount) {
        if(feedings.containsKey(type)) {
            int oldAmount = feedings.get(type);
            feedings.put(type, oldAmount + amount);
        } else {
            feedings.put(type, amount);
        }
    }

    @Override
    public Map<FoodTypes, Integer> getFeedingTotals() {
        return feedings;
    }
}
