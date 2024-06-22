package hashMap;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfniceSubArray {
    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for (int i=0; i<nums.length; i++) {
            if (nums[i] % 2 == 1) {
                sum++;
            }
            res += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }


    public static void main(String[] args){
        int[]arr = {2,1,2};
        System.out.println(numberOfSubarrays(arr,1));
    }
}
