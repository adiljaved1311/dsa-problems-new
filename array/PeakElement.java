package array;

public class PeakElement {
    public static void main(String[] args) {
        int arr[] = {1, 4, 6, 4, 5, 0, 3, 1};
        System.out.println(findPeak(arr, arr.length));
    }

    public static int findPeak(int arr[], int n) {
        return findPeekUtil(arr, 0, n - 1, n);
    }

    private static int findPeekUtil(int[] arr, int low, int high, int n) {
        int mid = (low + high) / 2;
        if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == n - 1 || (arr[mid + 1] < arr[mid]))) {
            return arr[mid];
        } else if (mid > 0 && arr[mid] < arr[mid - 1]) {  // no. should be in left half
            return findPeekUtil(arr, low, mid - 1, n);
        } else {
            return findPeekUtil(arr, mid + 1, high, n); // no. should be in right half
        }
    }

}
