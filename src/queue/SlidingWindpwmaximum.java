package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindpwmaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        int index = 0;
        ans[index++] = nums[dq.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            ans[index++] = nums[dq.peekFirst()];
        }
        return ans;
    }


    public static void main(String[] args) {
        int []arr = {1,3,-1,-3,5,3,6,7};
        int []arr2 = maxSlidingWindow(arr,3);
        System.out.println(Arrays.toString(arr2));
    }
}
