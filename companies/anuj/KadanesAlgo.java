package companies.anuj;

public class KadanesAlgo {
    public static void main(String[] args) {
        int arr[] = {1, 4, -7, -6, 5, -3, 7, 4};
        System.out.println(maxSumSubArray(arr));
    }

    private static int maxSumSubArray(int arr[]) {
        int currSum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if(maxSum < currSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}
