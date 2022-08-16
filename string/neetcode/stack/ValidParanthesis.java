package neetcode.stack;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValidPranthesis(s));
    }

    public static boolean isValidPranthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(c == ')' && stack.peek() == '('){
                        stack.pop();
                    }else if(c == '}' && stack.peek() == '{'){
                        stack.pop();
                    }else if(c == ']' && stack.peek() == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
