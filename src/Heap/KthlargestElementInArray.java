package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthlargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++){
            pq.offer(nums[i]);
        }

        int ans = -1;
        for(int j =0; j<k; j++){
            ans = pq.poll();
        }
        return ans;
    }



    public static void main(String[] args) {
        int[]arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));
    }
}
