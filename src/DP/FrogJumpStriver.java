package DP;

import java.util.Arrays;

public class FrogJumpStriver {

    public static int rec(int n, int[]arr){
        if(n ==0) return 0;

        int left = rec(n-1, arr) + Math.abs(arr[n]-arr[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = rec(n-2,arr) + Math.abs(arr[n] - arr[n-2]);

        return Math.min(left,right);
    }

    public static int memo(int n , int[]arr , int[]dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int left = rec(n-1, arr) + Math.abs(arr[n]-arr[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = rec(n-2,arr) + Math.abs(arr[n] - arr[n-2]);

        return dp[n] = Math.min(left,right);
    }


    public static int tabu(int n, int[]arr){
        int dp[] = new int[n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            int left =  dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1) right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);

            dp[i] = Math.min(left,right);
        }
        return dp[n];
    }

    public static int space(int n ,int[]arr){
        int prev2 = 0;
        int prev1 = 0;

        for(int i=1; i<=n; i++){
            int left =  prev1 + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1) right = prev2 + Math.abs(arr[i] - arr[i-2]);

            int cur = Math.min(left,right);

            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }


    public static void main(String[] args) {
        int[]arr = {10,20,30,10};
        int n = arr.length-1;
//        System.out.println(rec(n,arr));    // recursion
//
//        int[]dp = new int[n+1];          //memoization
//        Arrays.fill(dp,-1);
//        System.out.println(memo(n,arr,dp));

  //      System.out.println(tabu(n,arr));

        System.out.println(space(n,arr));
    }
}
