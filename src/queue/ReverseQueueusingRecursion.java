package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueusingRecursion {
    public static void rever(Queue<Integer> qu){
        if(qu.isEmpty()) return;

        int val = qu.remove();
        rever(qu);
        qu.add(val);
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
        rever(qu);
        System.out.println(qu);
    }
}
