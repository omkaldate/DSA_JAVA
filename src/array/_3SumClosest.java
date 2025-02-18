package array;

import java.util.Arrays;

public class _3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        while(i < (n - 2)) {
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int sum = nums[i];
                sum += nums[j];
                sum += nums[k];



                if(Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }

                if(sum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {-1,2,1,-4};
        System.out.println(threeSumClosest(arr,1));
    }
}
