package recursion;

public class CountNumberofMaximumBitwise_ORSubsets {
    public static int rec(int n, int[] nums, int currentOr, int maxOr) {
        if (n < 0) {
            return (currentOr == maxOr) ? 1 : 0;
        }

        int notTake = rec(n-1, nums, currentOr, maxOr);
        int take = rec(n-1, nums, currentOr|nums[n], maxOr);

        return notTake + take;
    }


    public static int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;

        for (int i = 0; i < n; i++) maxOr |= nums[i];

        return rec(n-1, nums, 0, maxOr);
    }


    public static void main(String[] args) {

    }
}
