package companies.mongodb;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

public class WordPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "0P";
        System.out.println(isPalindrome(s1));
    }

    private static boolean isPalindrome(String s) {
        // use 2 pointer
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            char left_char = sb.charAt(left);
            char right_char = sb.charAt(right);
            if (left_char == right_char) {
                left++; right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
