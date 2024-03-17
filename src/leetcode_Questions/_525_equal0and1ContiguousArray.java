package leetcode_Questions;

import java.util.HashMap;

public class _525_equal0and1ContiguousArray  {
    public static void main(String[] args){
        int []arr = {0,0,1,0,0,0,1,1};
        System.out.println(findMaxLength(arr));
    }

    public static int findMaxLength(int[] nums) {
        int n=nums.length;
        int sum =0;
        int ans=0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0, -1);

        for(int i=0; i<n; i++){
            sum += (nums[i] == 0) ? -1 : 1;

            if(mpp.containsKey(sum)){
                ans = Math.max(ans , i - mpp.get(sum));
            }
            else{
                mpp.put(sum , i);
            }
        }
        return ans;

        // return (ans == -1) ? 0 : ans;
    }
}
