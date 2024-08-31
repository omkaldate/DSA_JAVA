package HardProblems;

import java.util.Stack;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else max = Math.max(max,i-stack.peek());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
