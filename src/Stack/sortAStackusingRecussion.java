package Stack;

import java.util.Stack;

public class sortAStackusingRecussion {
    public Stack<Integer> sort(Stack<Integer> s) {

        fun(s);
        return s;
    }

    public void fun(Stack<Integer> stk){
        if(stk.isEmpty()) return;

        int val = stk.pop();
        fun(stk);

        sort(stk, val);
    }


    public void sort(Stack<Integer> stk, int val){
        if(stk.isEmpty()){
            stk.push(val);
            return;
        }

        if(stk.peek() < val){
            stk.push(val);
            return;
        }

        int temp = stk.pop();
        sort(stk, val);

        stk.push(temp);
    }



    public static void main(String[] args) {

    }
}
