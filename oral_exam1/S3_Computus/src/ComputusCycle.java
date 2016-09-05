import java.util.TreeMap;

/**
 * Created by jasonryan on 9/1/16.
 */

public class ComputusCycle {

    // Mothod to generate TreeMap containing all possible Easter dates and the number of occurences in each cycle
    public static TreeMap<Easter, Integer> generateCycleMap() {
        // Create map of easter dates and count of repeated dates
        TreeMap<Easter, Integer> easterTreeMap = new TreeMap<>();

        for (int i = 1; i <= 5700000; i++) {
            Easter e = new Easter(i);

            // Increment value if Easter date is in map else add date to map with initial value of one.
            if (easterTreeMap.containsKey(e))
                easterTreeMap.put(e, easterTreeMap.get(e) + 1);
            else
                easterTreeMap.put(e, 1);
        }

        return easterTreeMap;
    }


}
