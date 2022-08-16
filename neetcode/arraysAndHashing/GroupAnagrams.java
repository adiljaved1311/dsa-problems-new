package neetcode.arraysAndHashing;
/*
https://leetcode.com/problems/group-anagrams/
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] hash = new char[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        res.addAll(map.values());
        return res;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,Boolean> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            map.put(strs[i],false);
        }
        for (int i = 0; i < strs.length; i++) {
            if(map.get(strs[i]) == false){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(strs[i],true);
                for (int j = i + 1; j < strs.length; j++) {
                    if (isAnagram(strs[i], strs[j])) {
                        list.add(strs[j]);
                        map.put(strs[j],true);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    private static boolean isAnagram(String s, String t) {
        int alphabets[] = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 97]++;
            alphabets[t.charAt(i) - 97]--;
        }
        for (int alpha : alphabets) {
            if (alpha != 0) {
                return false;
            }
        }
        return true;
    }
}
