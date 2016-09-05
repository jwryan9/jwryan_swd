/**
 * Created by jasonryan on 9/1/16.
 */

import java.util.TreeMap;
import java.util.Map;

public class ComputusTest {
    public static void main(String[] args) {

        TreeMap<Easter, Integer> easterDateMap = ComputusCycle.generateCycleMap();

        for (Map.Entry<Easter, Integer> entry : easterDateMap.entrySet()) {
            Easter dateEntry = entry.getKey();
            int occurances = entry.getValue();
            System.out.println(dateEntry + " - " + occurances);
        }
    }
}
