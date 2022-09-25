package neetcode.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/contains-duplicate/

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
*/
public class ContainsDuplicate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (duplicate.add(nums[i]) == false) {
                return true;
            }
        }
        return false;
    }
}
