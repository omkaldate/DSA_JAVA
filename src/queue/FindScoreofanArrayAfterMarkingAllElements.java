package queue;

import java.util.PriorityQueue;

public class FindScoreofanArrayAfterMarkingAllElements {
    public static long findScore(int[] nums) {
        long sum = 0;
        int n = nums.length;
        boolean[] marked = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for(int i =0; i < n; i++){
            minHeap.offer(new int[]{nums[i], i});
        }

        while(!minHeap.isEmpty()){
            int curr[] = minHeap.poll();
            int mini = curr[0];
            int index = curr[1];
            if(!marked[index]){
                sum += nums[index];
                marked[Math.max(0, index - 1)] = true;
                marked[Math.min(n - 1, index + 1)] = true;
                marked[index] = true;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        
    }
}
