package Threading.MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Integer> q;
    private int size;

    BlockingQueue(int n){
        this.q = new LinkedList<>();
        this.size = n;
    }

    public boolean add(int a) {
        synchronized(q){
            while(q.size() == size){
                try {
                    q.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

                q.offer(a);
            q.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized(q){
            while(q.size() == 0){
                try {
                    q.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
                int val = q.poll();
            q.notifyAll();
                return val;
        }
    }
}
