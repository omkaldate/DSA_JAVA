package stack;

import java.util.Stack;

public class InsertAtBottonOfStack {

    public static void insert(Stack<Integer>stk ,int x){
        if(stk.isEmpty()){
            stk.push(x);
            return;
        }

        int val = stk.pop();
        insert(stk,x);
        stk.push(val);
    }



    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(5);
        stk.push(9);
        stk.push(12);
        stk.push(8);
        stk.push(4);

        insert(stk,10);

        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }
}
