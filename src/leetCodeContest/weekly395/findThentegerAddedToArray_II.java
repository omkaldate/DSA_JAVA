package leetCodeContest.weekly395;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findThentegerAddedToArray_II {
    public static void main(String[] args){
        int[] nums1 = {4,20,16,12,8};
        int[] nums2 = {14,18,10};
        System.out.println(minimumAddedInteger(nums1 , nums2));
    }

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                int diff = nums2[j] - nums1[i];
                map.put(diff, map.getOrDefault(diff, 0) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
            int diff = mp.getKey();
            int[] currentArray = new int[nums1.length];

            for(int i = 0; i < nums1.length; i++) {
                currentArray[i] = nums1[i] + diff;
            }

            Arrays.sort(currentArray);

            if(isPossible(currentArray, nums2)) {
                mini = Math.min(mini, diff);
            }
        }

        return mini;
    }

    public static boolean isPossible(int[] nums1, int[] nums2) {
        int i = 0, j = 0, numsleft = 2;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                i++;
                j++;
            }
            else {
                i++;
                numsleft--;

                if(numsleft < 0){
                    return false;
                }
            }
        }
        return (j == nums2.length && (i - j) <= 2);
    }
}
