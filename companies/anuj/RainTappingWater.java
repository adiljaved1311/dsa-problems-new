package companies.anuj;

public class RainTappingWater {
    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 4, 0, 1, 3, 2};
        System.out.println(storedWaterUnit(arr));
    }

    private static int storedWaterUnit(int arr[]) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        left[0] = arr[0];
        right[arr.length - 1] = arr[arr.length - 1];
        int storedWaterUnit = 0;

        // take an auxiliary array which have max left at that index
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        // take an auxiliary array which have max right at that index
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        // now the water stored at that index is its min at that index minus its own value
        for(int i=0;i<arr.length;i++){
            storedWaterUnit += Math.min(left[i],right[i]) - arr[i];
        }
        return storedWaterUnit;
    }
}
