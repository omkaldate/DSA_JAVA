package DP;

public class MaximumSumOfNonAdjacentElements {

    public static int fun(int n , int[]arr){
        if(n == 0) return arr[0];
        if(n <0) return 0;

        int take = arr[n] + fun(n-2, arr);
        int notTake = 0 + fun(n-1, arr);

        return Math.max(take , notTake);
    }


    public static int memo(int n , int[]arr , int[]dp){
        if(n == 0) return arr[0];
        if(n <0) return 0;
        if(dp[n] != -1) return dp[n];

        int take = arr[n] + fun(n-2, arr);
        int notTake = 0 + fun(n-1, arr);

        return dp[n] = Math.max(take , notTake);
    }


    public static int tabu(int n , int[] arr , int[]dp){
        dp[0] = arr[0];

        for(int i=1; i<n; i++){
            int take = arr[i] + ((i>1) ? dp[i-2] : 0);
            int notTake = 0 + dp[i-1];

            dp[i] = Math.max(take , notTake);
        }
        return dp[n-1];
    }


    public static int space(int n , int[] arr ){
        int prev1 = arr[0];
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int take = arr[i] + ((i>1) ? prev2 : 0);
            int notTake = 0 + prev1;

            prev2 = prev1;
            prev1 = Math.max(take , notTake);
        }
        return prev1;
    }


    public static int rob(int[] nums) {
        // return fun(nums.length-1, nums);   -- recursion

        // int[]dp = new int[nums.length];    -- memoization
        // Arrays.fill(dp,-1);
        // return memo(nums.length-1, nums, dp);

        // int[]dp = new int[nums.length];     -- tabulation
        // return tabu(nums.length ,nums ,dp);

        return space(nums.length, nums);       // space Opimization

    }

    public static void main(String[] args) {
        int[]nums = {2,1,4,9};
        System.out.println(rob(nums));
    }
}
