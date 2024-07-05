package stack;

import java.util.Stack;

public class SortStackusingRecursion {

    public static void divide(Stack<Integer>stk){
        if(stk.isEmpty()){
            return;
        }
        int num = stk.pop();
        divide(stk);
        sort(stk,num);
    }

    public static void sort(Stack<Integer>stk , int num){
        if(!stk.isEmpty() && stk.peek()<num  || (stk.isEmpty())){
            stk.push(num);
            return;
        }
        int x = stk.pop();
        sort(stk,num);
        stk.push(x);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(5);
        stk.push(9);
        stk.push(12);
        stk.push(8);
        stk.push(4);

        divide(stk);

        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }
}
