package hashMap;

import java.util.HashMap;

public class MakeSumDivisibleByP {

    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;

        HashMap<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,-1);

        int sum = 0;
        for(int i=0; i<n; i++) sum = (sum+nums[i]) %p;

        int target = sum;
        if(target == 0) return 0;

        sum = 0;
        int ans = n;

        for(int i=0; i<n; i++){
            sum =  (sum+nums[i]) %p;

            int prev = (sum - target + p) %p;
            if(mpp.containsKey(prev)){
                ans = Math.min(ans, i-mpp.get(prev));
            }
            mpp.put(sum, i);
        }
        return ans == n ? -1 : ans;
    }


    public static void main(String[] args) {

    }
}
