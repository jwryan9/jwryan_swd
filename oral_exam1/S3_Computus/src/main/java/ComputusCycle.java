package main.java;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jasonryan on 9/1/16.
 */

public class ComputusCycle {

    // Mothod to generate TreeMap containing all possible Easter dates and the number of occurences in each cycle
    private static TreeMap<Easter, Integer> generateCycleMap() {
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

    // Method to output occurances of Easter on each date in the cycle
    public static void displayCycleCounts() {
        TreeMap<Easter, Integer> easterTreeMap = generateCycleMap();

        Easter dateEntry;
        int occurrences;

        for (Map.Entry<Easter, Integer> entry : easterTreeMap.entrySet()) {
            dateEntry = entry.getKey();
            occurrences = entry.getValue();

            System.out.format("%8s - %6d\n", dateEntry, occurrences);
        }
    }


}
