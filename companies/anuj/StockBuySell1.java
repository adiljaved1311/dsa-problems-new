package companies.anuj;

// max profit between 2 days
// 1 day is for buying and 2nd day is for selling
public class StockBuySell1 {
    public static void main(String[] args) {
        int arr[] = {2, 4, 5, 6, 4, 9, 3};
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int arr[]) {   // T -> O(n) & S -> O(1)
        int maxProfit = 0;
        int minSoFar = arr[0];
        for (int i = 0; i < arr.length; i++) {
            minSoFar = Math.min(minSoFar,arr[i]);
            int profit = arr[i] - minSoFar;
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}
