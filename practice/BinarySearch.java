package practice;

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {0, 1, 3, 5, 7, 9, 11, 23, 45};
        System.out.println(binarySearch(a,23));
    }

    private static int binarySearch(int a[], int num) {
        int lower = 0;
        int upper = a.length - 1;
        while(lower <= upper){
            int mid = (lower + upper) / 2;
            if(a[mid] == num){
                return mid;
            }else if(num < a[mid]){
                upper = mid - 1;
            }else{
                lower = mid + 1;
            }
        }
        return -1;
    }
}
