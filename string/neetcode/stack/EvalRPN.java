package neetcode.stack;

import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        String[] token = {"2", "1", "+", "3", "*"};
        String str = "*";
        if (Integer.valueOf(str) >= 0) {
            System.out.println(Integer.valueOf(str));
        }
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int n2 = Integer.valueOf(stack.pop());
                int n1 = Integer.valueOf(stack.pop());
                if (token.equals("+")) {
                    result += add(n1, n2);
                    stack.push(result+"");
                } else if (token.equals("-")) {
                    result += subtract(n1, n2);
                } else if (token.equals("*")) {
                    result += multiplication(n1, n2);
                } else if (token.equals("/")) {
                    result += division(n1, n2);
                }
            } else {
                stack.push(token);
            }
        }
        return -1;
    }

    private static int add(int n1, int n2) {
        return n1 + n2;
    }

    private static int subtract(int n1, int n2) {
        return n1 - n2;
    }

    private static int multiplication(int n1, int n2) {
        return n1 * n2;
    }

    private static int division(int n1, int n2) {
        return n1 / n2;
    }
}
