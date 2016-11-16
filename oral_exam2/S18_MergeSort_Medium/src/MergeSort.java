import java.util.Arrays;

/**
 * Created by jasonryan on 11/15/16.
 */
public class MergeSort {

    private static int arrLen;

    /*
    public static void sort(int[] arr, int low, int high) {
        int middle = (low + high)/2;
        int[] first = Arrays.copyOfRange(arr, 0, middle);
        int[] last = Arrays.copyOfRange(arr, middle, arrLen);

        if (arrLen > 2) {
            //int middle = arrLen / 2;
//            int[] first = Arrays.copyOfRange(arr, 0, middle);
  //          int[] last = Arrays.copyOfRange(arr, middle, arrLen);

            sort(first, low, middle); // Sort first half
            sort(last, middle + 1, high); // Sort second half
        }
            merge(arr, first, last);
    }
    */

    public static void sort(int[] arr, int low, int high) {
        arrLen = arr.length;

        if((high - low) >= 1) {
            int middle = (low + high)/2;

            sort(arr, low, middle);
            sort(arr, middle + 1, high);

            merge(arr, low, middle, high);
        }
    }

    private static void merge(int[] arr, int low, int middle, int high) {
        int firstArrIndex = low;
        int secondArrIndex = middle + 1;
        int tempIndex = low;
        int[] temp = new int[arr.length];

        // Perform merge while both sides contain values
        while(firstArrIndex <= middle && secondArrIndex <= high) {
            if (arr[firstArrIndex] <= arr[secondArrIndex]) {
                temp[tempIndex++] = arr[firstArrIndex++];
            } else {
                temp[tempIndex++] = arr[secondArrIndex++];
            }
            System.out.println(Arrays.toString(temp));
        }

        // Fill array with remaining values
        if(firstArrIndex == (middle + 1)) {
            while(secondArrIndex <= high) {
                temp[tempIndex++] = arr[secondArrIndex++];
            }
        } else {
            while(firstArrIndex <= middle) {
                temp[tempIndex++] = arr[firstArrIndex++];
            }
        }

        // Return contents to original array
        for(int i=0; i<secondArrIndex; i++) {
            arr[i] = temp[i];
        }
    }

    /*
    private static void merge(int[] arr, int[] first, int[] last) {
        int i = 0, j = 0;

        while(i + j < arrLen) {
            if(j == last.length || ((i < first.length) && (first[i] < last[j]))) {
            //if(arr[i] <= arr[j]) {
                arr[i+j] = first[i++];
            } else {
                arr[i+j] = last[j++];
            }
        }
    }
    */
}
