/**
 * Created by jasonryan on 9/1/16.
 */

public class ComputusCycle {

    private void generateCycleArray() {
        Easter[] easterDates = new Easter[5700000];

        for (int i = 1; i < 5700000; i++) {
            Easter e = new Easter(i);
            easterDates[i] = e;
        }
    }

    public int repeatCount(Easter[] easterDates, int month, int day) {
        int count = 0;

        for(int i = 0; i < easterDates.length; i++) {

        }
        return count;
    }
}
