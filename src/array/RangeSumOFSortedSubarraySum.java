package array;

import java.util.Arrays;

public class RangeSumOFSortedSubarraySum {
    public static int rangeSum(int[] nums, int n, int left, int right) {

        int[] arr = new int[n * (n + 1) / 2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int j = i; j < n; j++) {
                pre += nums[j];
                arr[idx++] = pre;
            }
        }

        Arrays.sort(arr);

        long result = 0;
        for (int i = left-1; i<right; i++) {
            result += arr[i];
            result %= 1000000007;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4};
        System.out.println(rangeSum(arr , 4,1,5));
    }
}
