package leetCodeContest.Biweekly141;

import java.util.List;

public class ConstructTheMinimumBitwiseArray_I {
    public static int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            boolean found = false;

            for (int j = 0; j <= num; j++) {
                if ((j | (j + 1)) == num) {
                    ans[i] = j;
                    found = true;
                    break;
                }
            }
            if (!found) ans[i] = -1;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
