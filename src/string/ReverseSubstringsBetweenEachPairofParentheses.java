package string;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
    public static String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') stack.push(i);
            else if(s.charAt(i) == ')'){


                String toReverse = s.substring(stack.peek()+1, i);
                String reversedSubstring = new StringBuilder(toReverse).reverse().toString();
                s = s.substring(0, stack.peek()) + reversedSubstring + s.substring(i+1);
                stack.pop();
                i-=2;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String str = "(u(love)i)";
        System.out.println(reverseParentheses(str));
    }
}
