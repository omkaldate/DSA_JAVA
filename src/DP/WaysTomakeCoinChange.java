package DP;

public class WaysTomakeCoinChange {

    public static int rec(int ind , int tar, int[]arr){
        if(ind == 0){
            return (tar % arr[0] == 0) ? 1 : 0;
        }

        int notTake = rec(ind-1, tar, arr);
        int take = 0;
        if(arr[ind] <= tar) take = rec(ind, tar-arr[ind], arr);

        return  notTake + take;
    }


    public static int memo(int ind , int tar, int[]arr, int[][]dp){
        if(ind == 0){
            return (tar % arr[0] == 0) ? 1 : 0;
        }
        if(dp[ind][tar] != -1) return dp[ind][tar];

        int notTake = memo(ind-1, tar, arr, dp);
        int take = 0;
        if(arr[ind] <= tar) take = memo(ind, tar-arr[ind], arr, dp);

        return  dp[ind][tar] = notTake + take;
    }


    public static int tabu(int n, int tar, int[]arr){
        int[][]dp = new int[n][tar+1];

        for(int i=0; i<=tar; i++){
            dp[0][i] = (i % arr[0] == 0) ?1 :0;
        }

        for(int ind =1; ind< n; ind++){
            for(int t=0; t<=tar; t++){

                int notTake = dp[ind-1][t];
                int take = 0;
                if(arr[ind] <= t) take = dp[ind][t-arr[ind]];

                dp[ind][t] = take + notTake;
            }
        }
        return dp[n-1][tar];
    }



    public static int space(int n, int tar, int[]arr){
        int[]prev = new int[tar+1];

        for(int i=0; i<=tar; i++){
            prev[i] = (i % arr[0] == 0) ?1 :0;
        }

        for(int ind =1; ind< n; ind++){
            int[]temp = new int[tar+1];

            for(int t=0; t<=tar; t++){

                int notTake = prev[t];
                int take = 0;
                if(arr[ind] <= t) take = temp[t-arr[ind]];

                temp[t] = take + notTake;
            }
            prev = temp;
        }
        return prev[tar];
    }


    public static int change(int amount, int[] coins) {
        int n = coins.length;
        //return rec(n-1, amount, coins);    //recursion

        // int[][]dp = new int[n][amount+1];     //memoization
        // for(int[]x : dp) Arrays.fill(x,-1);
        // return memo(n-1, amount, coins, dp);


        // return tabu(n, amount, coins);      //tabulation

        return space(n, amount, coins);        //spaceoptimization
    }

    
    public static void main(String[] args) {

    }
}
