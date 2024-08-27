package Heap;

import java.util.PriorityQueue;

public class KthSumSumArray {
    public static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (pq.size() < k) pq.offer(sum);
              else if (sum > pq.peek()) {
                    pq.poll();
                    pq.offer(sum);
                }
            }
        }
        return pq.peek();
    }


public static void main(String[] args) {
    int[] arr = {2, 6, 4, 1};
    System.out.println(kthLargest(arr,3));


    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(2);
    pq.offer(3);
    pq.offer(30);
    System.out.println(pq.poll());
    System.out.println(pq.poll());
  }
}
