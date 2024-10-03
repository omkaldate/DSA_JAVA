package DP;

import java.util.Arrays;

public class HouseRobber {


    public static int spaceop(int[]arr){
        int prev1 = arr[0];
        int prev2 = 0;

        for(int i=1; i<arr.length; i++){
            int take = arr[i] + ((i>1) ? prev2 : 0);
            int notTake = 0 + prev1;

            int xx = Math.max(take , notTake);
            prev2 = prev1;
            prev1 = xx;
        }
        return prev1;
    }

    public static int rob(int[] nums) {
        if(nums.length==1)return nums[0];

        // int[]arr1 = new int[nums.length-1];
        // int[]arr2 = new int[nums.length-1];

        // for(int i=0; i<nums.length; i++){
        //     if(i >0) arr1[i-1] = nums[i];
        //     if(i<nums.length-1) arr2[i] = nums[i];
        // }
        // return Math.max(spaceop(arr1) , spaceop(arr2));

        return Math.max(spaceop(Arrays.copyOfRange(nums, 1, nums.length)) , spaceop(Arrays.copyOfRange(nums, 0 , nums.length-1)));
    }


    public static void main(String[] args) {
        int[]x = {8,9,10,11,12,13};
        System.out.println(rob(x));
    }
}
