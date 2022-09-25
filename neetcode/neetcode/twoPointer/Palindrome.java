package neetcode.twoPointer;

public class Palindrome {
    public static void main(String[] args) {
        String str = "race a car";
        System.out.println(isPalindrome(str));

    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char left_char = s.charAt(left);
            char right_char = s.charAt(right);
            if (!isValidAlphaNumeric(left_char)) {
                left++;
                continue;
            }
            if (!isValidAlphaNumeric(right_char)) {
                right--;
                continue;
            }
            if (left_char != right_char) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isValidAlphaNumeric(char c) {
        int num = c;
        if ((c >= 48 && c <= 57) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }
}
