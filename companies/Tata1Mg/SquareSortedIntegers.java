package companies.mongodb;

import java.util.Arrays;

public class SquareSortedIntegers {
    public static void main(String[] args) {
        int[] arr = {-4, -2, 1, 3, 5, 6, 8};
        int[] result = squareSortedIntegers(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] squareSortedIntegers(int[] arr) { // T -> O(n)
        // use 2 pointer theorem
        int[] result = new int[arr.length];
        int j = arr.length - 1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (Math.abs(arr[left]) >= Math.abs(arr[right])) {
                result[j--] = arr[left] * arr[left];
                left++;
            } else {
                result[j--] = arr[right] * arr[right];
                right--;
            }
        }
        return result;
    }
}
