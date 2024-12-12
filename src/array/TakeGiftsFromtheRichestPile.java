package array;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromtheRichestPile {
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : gifts) pq.add(num);

        for(int i=0;i<k;i++){
            int y=(int) Math.sqrt(pq.poll());
            pq.add(y);
        }
        long sum=0;
        for(int v:pq) sum+=v;

        return sum;
    }

    public static void main(String[] args) {
        
    }
}
