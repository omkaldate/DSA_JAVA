package DP;

import java.util.Arrays;

public class _0_1_Knapsack {


    public static int rec(int ind, int w, int[]val, int[]wt){
        if(ind == 0){
            if(wt[ind] <= w) return val[ind];
            return 0;
        }

        int notTake = rec(ind-1, w, val, wt);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= w) take = val[ind] + rec(ind-1, w-wt[ind], val, wt);

        return Math.max(take, notTake);
    }


    public static int memo(int ind, int w, int[]val, int[]wt, int[][]dp){
        if(ind == 0){
            if(wt[ind] <= w) return val[ind];
            return 0;
        }
        //if(dp[ind][w] != -1) return dp[ind][w];

        int notTake = rec(ind-1, w, val, wt);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= w) take = val[ind] + rec(ind-1, w-wt[ind], val, wt);


        return dp[ind][w] = Math.max(take, notTake);
    }


    public static int tabu(int n, int maxW, int[]val, int[]wt){
        int[][]dp = new int[n][maxW+1];

        for(int i= wt[0] ; i<=maxW; i++) dp[0][i] = val[0];

        for(int ind =1; ind<n; ind++){
            for(int w =0; w<=maxW; w++){

                int notTake = dp[ind-1][w];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= w) take = val[ind] + dp[ind-1][w-wt[ind]];

                dp[ind][w] = Math.max(take, notTake);
            }

        }
        for(int[]x : dp) System.out.println(Arrays.toString(x));
        return dp[n-1][maxW];
    }



    public static int space(int n, int maxW, int[]val, int[]wt){
        int[]prev = new int[maxW+1];

        for(int i= wt[0] ; i<=maxW; i++) prev[i] = val[0];

        for(int ind =1; ind<n; ind++){
            int[]temp = new int[maxW+1];
            for(int w =0; w<=maxW; w++){

                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= w) take = val[ind] + prev[w-wt[ind]];

                temp[w] = Math.max(take, notTake);
            }
            prev = temp;
        }
        return prev[maxW];
    }


    public static int spaceExtra(int n, int maxW, int[]val, int[]wt){
        int[]prev = new int[maxW+1];

        for(int i= wt[0] ; i<=maxW; i++) prev[i] = val[0];

        for(int ind =1; ind<n; ind++){
            for(int w =maxW; w>=0; w--){

                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= w) take = val[ind] + prev[w-wt[ind]];

                prev[w] = Math.max(take, notTake);
            }
        }
        return prev[maxW];
    }


    public static int knapSack(int W, int wt[], int val[]) {
        int n = wt.length;

        // return rec(n-1, W, val, wt);         // recursion

        //   int[][]dp = new int[n][W+1];          //memoization
        //   for(int[]x : dp) Arrays.fill(x, -1);
        //   int ans = memo(n-1, W, val, wt, dp);
        //   for(int[]x : dp) System.out.println(Arrays.toString(x));
        //   return ans;

        return tabu(n, W, val, wt);      //tabulation

        //return space(n,W, val, wt);     //spaceoptimization using 2 rows

        //return spaceExtra(n, W, val, wt);  // spaceopotimize using single row
    }



    public static void main(String[] args) {
        int[]w = {2,3,4,5};
        int[]v = {1,2,5,6};
        System.out.println(knapSack(8, w,v));
    }
}
