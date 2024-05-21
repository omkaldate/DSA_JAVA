package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queuebasic {
    public static void main(String[] args){
        Queue<Integer> que = new LinkedList<>();
        que.add(10);
        que.add(20);
        System.out.println(que.remove());
    }
}
