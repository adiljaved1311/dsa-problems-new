package neetcode.twoPointer;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number. Let these two numbers be
// numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

public class TwoSumII {
    public static void main(String[] args) {
        int numbers[] = {2,7,11,15};
        int target = 9;
        int result[] = twoSum(numbers,target);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int result[] = {-1,-1};
        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
        }
        return result;
    }
}
