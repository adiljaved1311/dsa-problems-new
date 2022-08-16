package companies.anuj;

public class InfiniteSortedArraySearch {
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 7, 9, 12, 45, 67, 89, 98, 105};
        System.out.println(infiniteSearch(arr,20));
    }

    private static int infiniteSearch(int arr[], int key) {
        int low = 0;
        int high = 1;
        while (arr[high] < key) {
            low = high;
            high = high * 2;
        }
        return binarySearch(low, high, key, arr);
    }

    private static int binarySearch(int low, int high, int key, int arr[]) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}


