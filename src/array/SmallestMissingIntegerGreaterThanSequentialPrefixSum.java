package array;

import java.util.Arrays;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public static int binary(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < arr[m]) {
                e = m-1;
            }
            else if (target > arr[m]) {
                s = m+1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int missingInteger(int[] nums) {
        if (nums.length == 0)
            return 0;
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]+1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        Arrays.sort(nums);
        System.out.println(sum);
        int index = binary(nums, sum);
        System.out.println("index of binary search = " + index);
        if (index == -1)
            return sum;

        if (index == nums.length - 1)
            return nums[index] + 1;

        int s=index;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1 || nums[i] == nums[i - 1] );
            else{
                return nums[i - 1] + 1;
            }
        }
        return nums[nums.length-1]+1;

    }

    public static void main(String[] args){
    int[] nums = {3,4,7,6,6,5,8,2,8,9,2,6};
        System.out.println(missingInteger(nums));
    }
}
