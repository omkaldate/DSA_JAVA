package hashMap;

import java.util.Arrays;

public class MinimumIncrementtoMakeArrayUnique {
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<=nums[i-1])
            {
                int val=nums[i];
                nums[i]=nums[i-1]+1;
                ans += nums[i]-val;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        int[]arr = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(arr));

    }
}
