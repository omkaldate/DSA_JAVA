package array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ugelyNumber__II {
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int[] primeFactors = { 2, 3, 5 };

        minHeap.offer(1L);
        set.add(1L);

        long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = minHeap.poll();

            for (int prime : primeFactors) {
                long nextUgly = currentUgly * prime;
                if (set.add(nextUgly)) {
                    minHeap.offer(nextUgly);
                }
            }
        }
        return (int) currentUgly;
    }


    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
