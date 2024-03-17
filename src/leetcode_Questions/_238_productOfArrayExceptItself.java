package leetcode_Questions;

import java.util.Arrays;

public class _238_productOfArrayExceptItself {
    public static void main(String[] args){
        int arr[] = {1,2,3,4};
        int ans[] = productExceptSelf(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];
        int[] right = new int[nums.length];
        int count = 1;
        for(int i=nums.length-1;i>=0;i--){
            right[i]= count;
            count *= nums[i];
        }
        count = 1;
        for(int i=0;i<nums.length;i++){
            ans[i] = count * right[i];
            count *= nums[i];
        }

        return ans;
    }
}
