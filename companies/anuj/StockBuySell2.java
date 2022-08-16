package companies.anuj;


// Total max profit
// no limit of buying and selling
public class StockBuySell2 {
    public static void main(String[] args) {
        int arr[] = {5, 2, 7, 3, 6, 1, 2, 4}; //11
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int arr[]) {
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]){
                maxProfit += arr[i] - arr[i-1];
            }
        }
        return maxProfit;
    }
}
