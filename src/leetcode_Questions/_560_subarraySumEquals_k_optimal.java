package leetcode_Questions;

import java.util.HashMap;
import java.util.Map;

public class _560_subarraySumEquals_k_optimal {
    public static void main(String[] args){
        int []arr = {1,2,1,4,2,1,1,2,2,3,4,6};
        System.out.println(subarraySum(arr , 8));
    }

    public static int subarraySum(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            int remove = preSum - k;
            cnt += mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}
