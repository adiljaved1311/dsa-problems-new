package neetcode.binarySearch;

public class SearchRotatedShiftedArray {
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(searchRotatedShiftedArray(nums,5));
    }

    public static int searchRotatedShiftedArray(int[] nums, int target){
        int firstElementIndex = firstElement(nums);
        System.out.println("Minumum -> "+nums[firstElementIndex]);
        if(target == nums[firstElementIndex]){
            return firstElementIndex;
        }else if(target < nums[0]){ // number should be in right
            return binarySearch(nums,firstElementIndex+1,nums.length-1,target);
        }else{ // number should be in left
            return binarySearch(nums,0,firstElementIndex-1,target);
        }
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // find the index of first element
    private static int firstElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == 0 || nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
