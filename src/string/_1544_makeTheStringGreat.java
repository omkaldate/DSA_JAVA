package string;

import java.util.Stack;

public class _1544_makeTheStringGreat {
    public static void main(String[] args){
        System.out.println(makeGood("leEeetcode"));
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0 ;i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && Math.abs(ch - stack.peek()) == 32) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}
