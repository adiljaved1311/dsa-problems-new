package practice;

public class StringAnagram {
    public static void main(String[] args) {
        String s1 = "host";
        String s2 = "tosh";
        System.out.println(isAnagram(s1,s2));
    }

    private static boolean isAnagram(String s1, String s2) {
        int a[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            a[c - 97]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            a[c - 97]--;
        }
        for (int count : a) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
