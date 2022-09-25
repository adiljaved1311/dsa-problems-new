package neetcode.arraysAndHashing;
/*
https://leetcode.com/problems/valid-anagram/
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
*/

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
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
