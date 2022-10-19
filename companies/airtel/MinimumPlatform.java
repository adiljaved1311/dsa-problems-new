package companies.airtel;

import java.util.Arrays;

public class MinimumPlatform {
    public static void main(String[] args) {
        //int arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00};
        //int dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00};
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    }

    public static int findPlatform1(int arr[], int dep[], int n) {  //T -> O(n^2)
        // plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, result = 1;
        // run a nested  loop to find overlap
        for (int i = 0; i < n; i++) {
            // minimum platform
            plat_needed = 1;
            for (int j = 0; j < n; j++) {
                if (i != j)
                    // check for overlap
                    if (arr[i] >= arr[j] && dep[j] >= arr[i])
                        plat_needed++;
            }
            // update result
            result = Math.max(result, plat_needed);
        }
        return result;
    }

    public static int findPlatform(int arr[], int dep[], int n) { // T -> O(n)
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        // plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        // Similar to merge in merge sort to process all events in sorted order
        while (i < n && j < n) {
            // If next event in sorted order is arrival, increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }
            // Else decrement count of platforms needed
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            // Update result if needed
            if (plat_needed > result)
                result = plat_needed;
        }
        return result;
    }
}
