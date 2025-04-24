package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class CountCompleteSubarraysinanArray {

    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int total = set.size();
        set.clear();

        HashMap<Integer,Integer> mpp = new HashMap<>();
        int i=0;
        int j=0;
        int ans = 0;
        int flag = 0;

        while(j<n && i<n){
            flag = 0;
            if(set.size() < total){
                mpp.put(nums[j], mpp.getOrDefault(nums[j],0)+1);
                flag = 1;
            }
            while(mpp.size() == total){
                ans += n-j;
                mpp.put(nums[i], mpp.get(nums[i])-1);
                if(mpp.get(nums[i]) == 0) mpp.remove(nums[i]);
                i++;
            }
            if(flag == 1) j++;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
