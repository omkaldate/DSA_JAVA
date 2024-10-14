package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++) pq.offer(nums[i]);

        long ans = 0;

        for(int i=0; i<k; i++){
            int value = pq.poll();
            ans += value;
            int cVal =(int) Math.ceil(value/3.0);
            pq.offer(cVal);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
