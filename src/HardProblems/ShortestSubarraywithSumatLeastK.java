package HardProblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarraywithSumatLeastK {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (long)nums[i];
        }
        int minLength = Integer.MAX_VALUE;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (queue.isEmpty() == false && prefixSum[i] <= prefixSum[queue.getLast()]) {
                queue.removeLast();
            }
            while (queue.isEmpty() == false && prefixSum[i] - prefixSum[queue.peek()] >= k) {
                minLength = Math.min(minLength, i - queue.poll());
            }
            queue.add(i);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
