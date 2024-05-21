package stack;

import java.util.Stack;

public class stackLearming {
    public static void main(String[] args){
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        System.out.println(stk.pop());
        System.out.println(stk.pop());

    }
}
