package leetcode_Questions;

import java.util.HashMap;
import java.util.Map;

public class _930_BinarySubArraySum_optimal {
    public static void main(String[] args) {

        int[] arr = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(arr , 2));
    }

    public static int numSubarraysWithSum(int[] arr, int goal) {
        int n = arr.length;
        Map<Integer , Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            int remove = preSum - goal;
            cnt += mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}

