package DP;

public class Fibonacci {

    public static int rec(int n){
        if(n < 2) return n;
        return rec(n-1) + rec(n-2);
    }

    public static int memo(int n , int[]dp){
        if(n < 2) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = memo(n-1,dp) + memo(n-2,dp);
    }

    public static int tabu(int n){
        int prev2 = 0;
        int prev1 = 1;

        for(int i=2; i<=n; i++){
            int cur = prev2 + prev1;

            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }


    public static int fib(int n) {
        if(n < 2) return n;

        // return rec(n);       // recursion

        //  int[]dp = new int[n+1];    // memoization
        //  Arrays.fill(dp,-1);
        //  dp[0] = 0;
        //  dp[1] = 1;
        //  return memo(n,dp);


        return tabu(n);              //tabulation
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
