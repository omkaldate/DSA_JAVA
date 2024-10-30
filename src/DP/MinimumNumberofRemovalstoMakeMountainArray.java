package DP;

public class MinimumNumberofRemovalstoMakeMountainArray {
    public static int minimumMountainRemovals(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }

        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        for(int i = 0; i < n; i++) {
            LIS[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            LDS[i] = 1;
            for(int j = n - 1; j > i; j--) {
                if(nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        int minRemovals = n;
        for(int i = 1; i < n - 1; i++) {
            if(LIS[i] > 1 && LDS[i] > 1) {
                int mountainLength = LIS[i] + LDS[i] - 1;
                minRemovals = Math.min(minRemovals, n - mountainLength);
            }
        }
        return minRemovals;
    }


    public static void main(String[] args) {
     
    }
}
