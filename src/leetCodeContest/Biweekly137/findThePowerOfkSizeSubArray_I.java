package leetCodeContest.Biweekly137;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findThePowerOfkSizeSubArray_I {
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    isConsecutive = false;
                    break;
                }
            }
            if (isConsecutive) {
                list.add(nums[i + k - 1]);
            } else {
                list.add(-1);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,3,2,5};
        int k = 3;
        System.out.println(Arrays.toString(resultsArray(arr , k)));
    }
}
