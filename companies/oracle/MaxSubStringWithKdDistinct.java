package companies.oracle;

import java.util.HashSet;

public class MaxSubStringWithKdDistinct {
    public static void main(String[] args) {
        String str = "abcbdfexcgba";
        String str1 = "abcaed";
        String str2 = "abcabcd";
        System.out.println(maxSubString(str2));
    }

    private static String maxSubString(String s) {  // T -> O(n) -> S -> O(1)
        String maxSubString = "";
        String subString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (subString.contains(c + "")) {
                if (maxSubString.length() < subString.length()) {
                    maxSubString = subString;
                }
                subString = subString.substring(1, subString.length()) + c;
            } else {
                subString += c;
                if (maxSubString.length() < subString.length()) {
                    maxSubString = subString;
                }
            }
        }
        return maxSubString;
    }
}
