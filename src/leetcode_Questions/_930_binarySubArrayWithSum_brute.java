package leetcode_Questions;

public class _930_binarySubArrayWithSum_brute {
    public static void main(String[] args) {

        int[] arr = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(arr , 2));

    }


    public static int numSubarraysWithSum(int[] nums, int goal) {

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                }
            }
        }
        return count;
    }
}
