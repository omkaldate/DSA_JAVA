package slidingWindow;

import java.util.HashMap;

public class _2958_lengthOfSubarrWithAtMostKFreq {
    public static void main(String[] args){
        int[]arr = {1,2,3,1,2,3,1,2};
        System.out.println(maxSubarrayLength(arr , 2));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i=0,j=0,res=0;
        HashMap<Integer,Integer> mpp = new HashMap<>();

        while(j<n){
            mpp.put(nums[j] , mpp.getOrDefault(nums[j],0)+1);

            while(i<j && mpp.get(nums[j]) > k){
                mpp.put(nums[i] , mpp.get(nums[i])-1);
                i++;
            }
            res = Math.max(res , j-i+1);
            j++;
        }
        return res;
    }
}
