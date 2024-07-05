package stack;

import java.util.Stack;

public class ReverseStackUsingRecusrion {

    public static void reverse(Stack<Integer>stk){
        if(stk.isEmpty()){
            return;
        }
        int num = stk.pop();
        reverse(stk);
        insertBottom(stk,num);
    }

    public static void insertBottom(Stack<Integer>stk,int x){
        if(stk.isEmpty()){
            stk.push(x);
            return;
        }
        int num = stk.pop();
        insertBottom(stk,x);
        stk.push(num);
    }


    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(5);
        stk.push(9);
        stk.push(12);
        stk.push(8);
        stk.push(4);

        reverse(stk);

        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }
}
