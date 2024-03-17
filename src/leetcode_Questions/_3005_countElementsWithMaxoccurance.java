package leetcode_Questions;

import java.util.HashMap;
import java.util.Map;

public class _3005_countElementsWithMaxoccurance {

    public static void main(String[] args){
        int[]arr = {2,3,4,5,6,7,3,4,7};
        System.out.println(maxFreq(arr));
    }

    public static int maxFreq(int[] nums) {
        int count = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxFreq = 0;

        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, mpp.get(num));
        }

        for (int freq : mpp.values()) {
            if (freq == maxFreq)    count += freq;
        }

        return count;

    }
}
