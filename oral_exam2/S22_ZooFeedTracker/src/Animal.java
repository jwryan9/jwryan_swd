import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class representing all animal types
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

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return("Name: " + getName() + "\nLocation: " + getLocation() +
                "\nType: " + getAnimalType() + "\nFood Types: " + getFoodTypes() +
                "\nFeedings (lbs): " + getFeedingTotals());
    }

    public abstract String getAnimalType();
    public abstract List<String> getFoodTypes();
    public abstract void addFeeding(String type, int amount);
    public abstract HashMap<String, Integer> getFeedingTotals();
    public abstract void resetFeedingTotals();

}
