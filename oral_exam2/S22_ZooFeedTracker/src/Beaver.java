import java.util.Map;

/**
 * @author Jason Ryan
 */
public class Beaver extends Animal {

    //private enum FoodTypes {BASS, HAY}

    public Beaver(String name, String location) {
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
    public Map<FoodTypes, Integer> getFeedingTotals() {
        return null;
    }
}
