package companies.paytm;

public class BinarySort {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 2, 2, 0, 1, 2, 1, 1, 0, 0};
        binarySort(arr);
        for (int x : arr) {
            System.out.print(x + ", ");
        }
    }

    private static void binarySort(int arr[]) {  // T -> O(n)  && S -> O(1)
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 1) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
    }
}
