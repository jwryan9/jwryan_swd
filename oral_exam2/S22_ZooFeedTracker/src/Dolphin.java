import java.util.Map;

/**
 * @author Jason Ryan
 */
public class Dolphin extends Animal {

    public Dolphin(String name, String location) {
        super(name, location);
    }

    @Override
    public String getAnimalType() {
        return null;
    }

    @Override
    public FoodTypes getFoodTypes() {
        return null;
    }

    @Override
    public void addFeeding(FoodTypes type, int amount) {

    }

    @Override
    public Map<Beaver.FoodTypes, Integer> getFeedingTotals() {
        return null;
    }
}
