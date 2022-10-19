package companies.airtel;
// sorted array rows wise and column wise find a number
public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,4},
                {3,5,6},
                {7,8,9}
        };
        search(arr,17);
    }
    public static void search(int[][] arr, int num){
        int i = 0; // 0,1,2
        int j = arr[0].length-1; // 0,1,2
        while(i >= 0 && i < arr.length && j >= 0 && j < arr.length){
            if(num == arr[i][j]){
                System.out.println(i+","+j);
                return;
            }else if(num < arr[i][j]){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("-1,-1");
    }
}
