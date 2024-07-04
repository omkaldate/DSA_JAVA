package stack;

import java.util.Stack;

public class DeleteMiddeleElement {

    public static void remove(Stack<Integer>stk ,int index,int cnt ){
       if(cnt == index){
        stk.pop();
        return;
    }
       int val = stk.pop();
       remove(stk,index,cnt+1);
       stk.push(val);
    }

    public static void main(String[] args) {
        Stack<Integer>stk = new Stack<>();
        stk.push(5);
        stk.push(9);
        stk.push(12);
        stk.push(8);
        stk.push(4);

       remove(stk,stk.size()/2,0);

        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }

}
