package array;

/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/
350. Intersection of Two Arrays II
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ArrayIntersection {
    public static void main(String[] args) {
        int arr1[] = {4,9,5};
        int arr2[] = {9,4,9,8,4};
        int output[] = arrayIntersection(arr1,arr2);
        for(int x : output){
            System.out.print(x+" ");
        }
    }

    private static int[] arrayIntersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                duplicates.add(arr2[i]);
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }
        int[] result = new int[duplicates.size()];
        int index = 0;
        for(int x : duplicates){
            result[index++] = x;
        }
        return result;
    }
}
