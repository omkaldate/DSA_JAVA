package DP;

public class UnboundedKnapsack {

    public static int rec(int ind, int w, int[]wt, int[]val){
        if(ind ==0){
            return (w/wt[0]) * val[0];
        }

        int notTake = rec(ind-1, w, wt, val);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= w) take = val[ind] + rec(ind, w-wt[ind], wt, val);

        return Math.max(notTake, take);
    }


    public static int memo(int ind, int w, int[]wt, int[]val, int[][]dp){
        if(ind ==0){
            return (w/wt[0]) * val[0];
        }
        if(dp[ind][w] != -1) return dp[ind][w];

        int notTake = memo(ind-1, w, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= w) take = val[ind] + memo(ind, w-wt[ind], wt, val, dp);

        return dp[ind][w] =  Math.max(notTake, take);
    }


    public static int tabu(int n, int w, int[]val, int[]wt){
        int[][]dp = new int[n][w+1];

        for(int i=0; i<=w; i++) dp[0][i] = (i/wt[0]) * val[0];

        for(int ind=1; ind<n; ind++){
            for(int weigh =0; weigh <= w; weigh++){

                int notTake = dp[ind-1][weigh];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= weigh) take = val[ind] + dp[ind][weigh -wt[ind]];

                dp[ind][weigh] = Math.max(take , notTake);
            }
        }
        return dp[n-1][w];
    }



    public static int space(int n, int w, int[]val, int[]wt){
        int[]prev = new int[w+1];

        for(int i=0; i<=w; i++) prev[i] = (i/wt[0]) * val[0];

        for(int ind=1; ind<n; ind++){
            int[]temp = new int[w+1];
            for(int weigh =0; weigh <= w; weigh++){

                int notTake = prev[weigh];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= weigh) take = val[ind] + temp[weigh -wt[ind]];

                temp[weigh] = Math.max(take , notTake);
            }
            prev  = temp;
        }
        return prev[w];
    }


    public static int knapSack(int N, int W, int val[], int wt[]){
        //return rec(N-1, W, wt, val);   // recursion

        //   int[][]dp = new int[N][W+1];         //memoization
        //   for(int[]x : dp)  Arrays.fill(x,-1);
        //   return memo(N-1, W, wt, val, dp);

        // return tabu(N, W, val, wt);     //tabulation

        return space(N, W, val, wt);
    }

    public static void main(String[] args) {

    }
}
