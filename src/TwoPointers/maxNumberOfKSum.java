package TwoPointers;

import java.util.Arrays;

public class maxNumberOfKSum {

    public static int maxOperations(int[] nums, int k) {
        int zeroesCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                nums[i] = 0;
                zeroesCount++;
            }
        }

        Arrays.sort(nums);

        int i = zeroesCount;
        int j = nums.length - 1;
        int result = 0;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                result++;
                i++;
                j--;
            }
            else if (sum < k) i++;
            else j--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[]arr = {3,1,3,4,3};
        System.out.println(maxOperations(arr,6));
    }
}
