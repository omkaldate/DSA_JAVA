package TwoPointers;

import java.util.Arrays;

public class CounttheNumberofFair {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length;
        Arrays.sort(nums);
        return getLess(nums,upper+1) - getLess(nums,lower);
    }

    private long getLess(int nums[],int sum) {
        int i=0;
        int j=nums.length-1;
        long res=0;
        while(i<=j) {
            if(nums[i] + nums[j] < sum) {
                res += j-i;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
