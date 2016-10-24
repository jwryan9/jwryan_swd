import java.util.Enumeration;
import java.util.Map;

/**
 *
 * @author Jason Ryan
 */
public abstract class Animal {
    private final String name;
    private final String location;

    public Animal(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getAnimalName() {
        return name;
    }

    public abstract String getAnimalType();
    public abstract Enumeration<String> getFoodTypes();
    public abstract void addFeeding(String type, int amount);
    public abstract Map<String, Integer> getFeedingTotals();

}
