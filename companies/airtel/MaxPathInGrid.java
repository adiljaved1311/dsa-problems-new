package companies.airtel;
/*
The problem is to count all the possible paths from top left to bottom right of
a mXn matrix with the constraints that from each cell you can either move only to right or down
 */
public class MaxPathInGrid {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println(countNumberOfPath(m,n));
    }
    public static int countNumberOfPath(int m, int n){  // T-> (2^n)
        if(m == 1 || n == 1){
            return 1;
        }
        return countNumberOfPath(m-1,n) + countNumberOfPath(m,n-1);
    }
}
