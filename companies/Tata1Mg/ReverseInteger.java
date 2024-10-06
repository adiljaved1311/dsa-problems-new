package companies.mongodb;

// Reverse an integer without turning it into a String
public class ReverseInteger {
    public static void main(String[] args) {
        int num = 1346;
        System.out.println(reverse(num));
    }
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int remainder = x % 10;
            result = result * 10 + remainder;
            x = x / 10;
        }
        return result;
    }
}
