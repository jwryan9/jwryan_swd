/**
 * Class with static methods to perform merge sort on an integer array
 *
 * @author Jason Ryan
 */
public class MergeSort {

    /**
     * Sorts array recursively, splits array into subarrays and sorts each individually
     * before merging the arrays together.
     *
     * @param arr Integer array to be sorted
     * @param low First index of the array to be sorted
     * @param high Final index of the array to be sorted
     */
    public static void sort(int[] arr, int low, int high) {
        if((high - low) >= 1) {
            int middle = (low + high)/2;

            sort(arr, low, middle);
            sort(arr, middle+1, high);

            merge(arr, low, middle, high);
        }
    }

    /**
     * Merge sorted subarrays into one sorted array, copied into original array.
     *
     * @param arr Array to be merged
     * @param low Initial index of array
     * @param middle Middle index of array
     * @param high Last index of array
     */
    private static void merge(int[] arr, int low, int middle, int high) {
        int firstArrIndex = low;
        int secondArrIndex = middle + 1;
        int tempIndex = low;
        int[] temp = new int[arr.length];

        // Perform merge while both sides contain values
        while (firstArrIndex <= middle && secondArrIndex <= high) {
            if (arr[firstArrIndex] <= arr[secondArrIndex]) {
                temp[tempIndex++] = arr[firstArrIndex++];
            } else {
                temp[tempIndex++] = arr[secondArrIndex++];
            }
        }

        // Fill array with remaining values
        if (firstArrIndex == (middle + 1)) {
            while (secondArrIndex <= high) {
                temp[tempIndex++] = arr[secondArrIndex++];
            }
        } else {
            while (firstArrIndex <= middle) {
                temp[tempIndex++] = arr[firstArrIndex++];
            }
        }

        // Return contents to original array
        for (int i = low; i < secondArrIndex; i++) {
            arr[i] = temp[i];
        }
    }
}
