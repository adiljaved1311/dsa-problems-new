package array;

/*
https://leetcode.com/problems/length-of-last-word/
Given a string s consisting of some words separated by some number of spaces,
return the length of the last word in the string.
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
 */

public class LengthLastWord {
    public static void main(String[] args) {
        String s = "Hi Hello  World  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        boolean flag = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            String c = s.charAt(i) + "";
            if (!c.equals(" ")) {
                right = i;
                break;
            }
        }
        String lastWord = "";
        while (flag && right >= 0) {
            String c = s.charAt(right) + "";
            if (c.equals(" ")) {
                flag = false;
                return lastWord.length();
            }
            lastWord += s.charAt(right);
            right--;
        }
        return lastWord.length();
    }
}
