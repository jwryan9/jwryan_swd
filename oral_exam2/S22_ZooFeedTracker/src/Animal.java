import java.util.Map;

/**
 * Abstract class representing all animal types
 *
 * @author Jason Ryan
 */
public abstract class Animal {
    private final String name;
    private final String location;

    enum FoodTypes {BASS, HAY, PEANUTS, SHRIMP, ZEBRA}

    public Animal(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getAnimalName() {
        return name;
    }

    public abstract String getAnimalType();
    public abstract FoodTypes getFoodTypes();
    public abstract void addFeeding(FoodTypes type, int amount);
    public abstract Map getFeedingTotals();

}
