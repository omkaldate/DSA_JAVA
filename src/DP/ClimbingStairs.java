package DP;

public class ClimbingStairs {
    public static int rec(int n){
        if(n == 0 || n ==1) return 1;

        int left = rec(n-1);
        int right = rec(n-2);

        return left + right;
    }

    public static int memo(int n, int[]dp){
        if(n ==0 || n ==1) return 1;
        if(dp[n] != -1) return dp[n];

        int left = memo(n-1,dp);
        int right = memo(n-2,dp);
        return dp[n] = left + right;
    }

    public static int tabu(int n){
        int prev2 = 1;
        int prev1 = 1;

        for(int i=2; i<=n; i++){
            int cur = prev2 + prev1;

            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }


    public static int climbStairs(int n) {
        //  return rec(n);     // recursion

        // int[]dp = new int[n+1];    //memoization
        // Arrays.fill(dp,-1);
        // dp[0] = 1;
        // dp[1] = 1;
        // return memo(n,dp);

        return tabu(n);         // tabulation
    }

    public static void main(String[] args) {

    }
}
