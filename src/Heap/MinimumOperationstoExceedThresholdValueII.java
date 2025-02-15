package Heap;

import java.util.PriorityQueue;

public class MinimumOperationstoExceedThresholdValueII {
    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> qu = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            qu.offer((long) nums[i]);
        }
        long ans = 0;

        while(qu.peek() < k){
            long a = qu.poll();
            long b = qu.poll();
            qu.offer((a*2) + b);
            ans++;
        }

        return (int)ans;
    }


    public static void main(String[] args) {

    }
}
