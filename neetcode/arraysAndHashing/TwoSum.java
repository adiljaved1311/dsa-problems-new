package neetcode.arraysAndHashing;

import java.util.HashMap;

/*
https://leetcode.com/problems/two-sum/
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
 */
public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int output[] = twoSum(nums,target);
        for(int x : output){
            System.out.print(x + ", ");
        }
    }

    public static int[] twoSum(int nums[], int target) {
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if(map.containsKey(difference)){
                result[0] = map.get(difference);
                result[1] = i;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
