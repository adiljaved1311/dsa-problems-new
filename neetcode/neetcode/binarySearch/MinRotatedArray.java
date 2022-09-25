package neetcode.binarySearch;

public class MinRotatedArray {
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minimum = nums[0];
        while (left <= right) {
            if (nums[left] < nums[right]) {
                minimum = Math.min(minimum, nums[left]);
                break;
            }
            int mid = (left + right) / 2;
            minimum = Math.min(minimum, nums[mid]);
            if (nums[mid] >= nums[left]) {  // if mid is greater than left than the no. should be in right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return minimum;
    }
}
