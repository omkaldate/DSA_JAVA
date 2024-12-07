package binarySearch;

import java.util.Arrays;

public class MinimumLimitofBallsinaBag {
    public static boolean isPossible(int[] nums, int maxOps, int mid) {
        int totalOps = 0;

        for (int num : nums) {
            int ops = num / mid;

            if (num % mid == 0) {
                ops -= 1;
            }

            totalOps += ops;
        }

        return totalOps <= maxOps;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        int result = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isPossible(nums, maxOperations, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}
