package array;

/*
https://leetcode.com/problems/longest-palindromic-substring/
Given a string s, return the longest palindromic substring in s.
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
 */

public class LongestPalindromicString {
    public static void main(String[] args) {
        String s = "habbar";
        System.out.println(longestPalindrome(s));
    }


    private static String longestPalindrome(String s) { // T->O(n^3)
        String longestPalindrome = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String subString = new String(s.charAt(i) + "");
            for (int j = i + 1; j < s.length(); j++) {
                String c = new String(s.charAt(j) + "");
                subString = subString + c;
                String reverse = reverse(subString);
                if (subString.equals(reverse)) {
                    if (longestPalindrome.length() < subString.length()) {
                        longestPalindrome = subString;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    private static String reverse(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }
}
