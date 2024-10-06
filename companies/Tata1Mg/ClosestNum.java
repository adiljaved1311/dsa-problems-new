package companies.mongodb;

public class ClosestNum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 8, 9, 15, 18, 20};
        int target = 17;
        System.out.println(closestNum(arr,target));
    }

    private static int closestNum(int[] arr, int target){
        int min_difference = Integer.MAX_VALUE;
        int closest_num = arr[0];
        for (int x : arr){
            int absolute_difference = Math.abs(target - x);
            if(absolute_difference < min_difference){
                closest_num = x;
                min_difference = absolute_difference;
            }
        }
        return closest_num;
    }
}
