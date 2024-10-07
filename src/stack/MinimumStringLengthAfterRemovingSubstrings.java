package stack;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {

    public static int minLength(String s) {
        Stack<Character> stk = new Stack();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stk.isEmpty() && ch == 'B' ){
                if('A' == stk.peek()) stk.pop();
                else stk.push(ch);
            }
            else if(!stk.isEmpty() && ch == 'D' ){
                if('C' == stk.peek()) stk.pop();
                else stk.push(ch);
            }
            else stk.push(ch);
        }
        return stk.size();
    }


    public static void main(String[] args) {

    }
}
