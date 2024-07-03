package queue.QueueUsingTwoStacks;

import java.util.Stack;

public class Queue {
    private Stack<Integer> stk1 ;
    private Stack<Integer> stk2 ;

    Queue(){
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    public void add(int item){
       while(!stk1.empty()){
           stk2.push(stk1.pop());
        }
       stk2.push(item);
        while(!stk2.empty()){
            stk1.push(stk2.pop());
        }
    }

    public int remove(){
        return stk1.pop();
    }

    public boolean isEmpty(){
        return stk1.isEmpty();
    }
}
