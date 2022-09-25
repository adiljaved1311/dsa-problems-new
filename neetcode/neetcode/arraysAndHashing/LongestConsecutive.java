package neetcode.arraysAndHashing;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//https://leetcode.com/problems/longest-consecutive-sequence/submissions/

import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        int arr[] = {100, 4, 200,5, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int max_seqn_count = 0;
        for (int x : arr) {
            set.add(x);
        }
        for (int i = 0; i < arr.length; i++) {
            int seqn_count = 1;
            if(set.contains(arr[i]-1)){
                continue;
            }else{
                int j = 1;
                while(set.contains(arr[i]+j)){
                    seqn_count++;
                    j++;
                }
            }
            max_seqn_count = Math.max(max_seqn_count,seqn_count);
        }
        return max_seqn_count;
    }
}
