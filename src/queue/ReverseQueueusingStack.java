package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueusingStack {
    public static void reverStk(Queue<Integer> qu){
       Stack<Integer>stk = new Stack<>();
       while(!qu.isEmpty()){
           stk.push(qu.remove());
       }
       while(!stk.isEmpty()){
           qu.add(stk.pop());
       }
    }


    public static void main(String[] args) {
        Queue<Integer> qu = new LinkedList<>();

        qu.add(4);
        qu.add(3);
        qu.add(1);
        qu.add(10);
        qu.add(2);
        qu.add(6);
        System.out.println(qu);
        reverStk(qu);
        System.out.println(qu);
    }
}
