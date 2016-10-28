import java.util.Enumeration;
import java.util.Map;

/**
 * @author Jason Ryan
 */
public class Elephant extends Animal {

    public Elephant(String name, String location) {
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
    public Map<Animal.FoodTypes, Integer> getFeedingTotals() {
        return null;
    }
}
