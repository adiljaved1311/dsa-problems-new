package companies.cvent;

import java.util.Arrays;

public class MinDifference {
    public static void main(String[] args) {
        int arr[] = {13, 5, 1, 7, 9, 16, 25};   // 1,5,7,9,13,15,16
        int result[] = minDifference(arr);
        for (int x : result) {
            System.out.print(x + ", ");
        }
    }

    // Find 2 number in the array whose difference is minimum. Array is unsorted.
    // Complexity should be less than o(nlogn).

    private static int[] minDifference(int arr[]) {
        int result[] = new int[]{-1, -1};
        Arrays.sort(arr);
        int minDifference = arr[arr.length - 1] - arr[arr.length - 2];
        result[0] = arr[arr.length - 1];
        result[1] = arr[arr.length - 2];
        for (int i = arr.length - 2; i > 0; i--) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDifference) {
                minDifference = diff;
                result[0] = arr[i];
                result[1] = arr[i - 1];
            }
        }
        return result;
    }
}
