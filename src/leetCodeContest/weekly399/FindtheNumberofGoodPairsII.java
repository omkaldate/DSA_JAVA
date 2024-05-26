package leetCodeContest.weekly399;

import java.util.HashMap;
import java.util.Map;

public class FindtheNumberofGoodPairsII {
    public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long count = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        for (int num2 : map2.keySet()) {
            for (int multiple = 1; multiple * num2 * k <= 1000000; multiple++) {
                int target = multiple * num2 * k;
                if (map1.containsKey(target)) {
                    count += map1.get(target) * (long) map2.get(num2);
                }
            }
        }

        return count;
    }

    public static void main(String [] args){
        int[]nums1 = {1,3,4};
        int[]nums2 ={1,3,4};
        int k = 1;
        System.out.println(numberOfPairs(nums1 , nums2, k));
    }
}
