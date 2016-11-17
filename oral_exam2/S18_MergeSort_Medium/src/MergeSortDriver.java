import java.util.Arrays;
import java.util.Random;

/**
 * Driver program to show the capabilities of MergeSort program
 *
 * @author Jason Ryan
 */
public class MergeSortDriver {
    private static final int ARR_LEN = 100;

    /**
     * Main method
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[ARR_LEN];
        Random random = new Random();

        for(int i=0; i<ARR_LEN; i++) {
            arr[i] = random.nextInt(1001);
        }

        System.out.println("Original: " + Arrays.toString(arr));
        MergeSort.sort(arr, 0, ARR_LEN - 1);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}
