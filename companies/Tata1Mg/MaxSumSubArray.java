package companies.mongodb;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumSubArray(arr));
    }

    private static int maxSumSubArray(int[] arr) {
        int max_sum = arr[0];
        int curr_sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr_sum = Math.max(arr[i], (curr_sum + arr[i]));
            max_sum = Math.max(curr_sum, max_sum);
        }
        return max_sum;
    }
}
