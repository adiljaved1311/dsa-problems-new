package neetcode.slidingWindow;
/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */
import java.util.HashSet;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
