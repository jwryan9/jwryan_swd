import java.util.HashMap;
import java.util.List;

/**
 * Abstract class representing all animal types
 *
 * @author Jason Ryan
 */
public abstract class Animal {
    private final String name;
    private final String location;

    /**
     * Constructor for Animal objects
     *
     * @param name the name of the animal
     * @param location the location of the animal in the zoo
     */
    public Animal(String name, String location) {
        this.name = name;
        this.location = location;
    }

    /**
     * Returns the name of an animal object
     *
     * @return the name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the location of the animal in the zoo
     *
     * @return the animal's location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Generates string representation of zoo animal
     *
     * @return string representation of animal, including: name, location, type, food type, and feedings
     */
    @Override
    public String toString() {
        return("Name: " + getName() + "\nLocation: " + getLocation() +
                "\nType: " + getAnimalType() + "\nFood Types: " + getFoodTypes() +
                "\nFeedings (lbs): " + getFeedingTotals());
    }

    /**
     * Abstract method declaration for getting animal type
     *
     * @return animal type
     */
    public abstract String getAnimalType();

    /**
     * Abstact method declaration for getting types of food an animal eats
     *
     * @return list of food types
     */
    public abstract List<String> getFoodTypes();

    /**
     * Abstract method declaration for feeding an animal
     *
     * @param type food type
     * @param amount lbs of food to feed
     */
    public abstract void addFeeding(String type, int amount);

    /**
     * Abstract method declaration for getting the amount of food an animal has been fel
     *
     * @return HashMap of food types and amount in lbs
     */
    public abstract HashMap<String, Integer> getFeedingTotals();

    /**
     * Abstract method declaration for resetting an animal's feedings to zero
     */
    public abstract void resetFeedingTotals();

}
