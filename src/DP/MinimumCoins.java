package DP;

public class MinimumCoins {

    public static int rec(int ind, int T, int[]arr){
        if(ind == 0){
            if(T % arr[0] == 0) return T/arr[0];
            else return (int)1e9;
        }

        int notTake = rec(ind-1, T, arr);
        int take = Integer.MAX_VALUE;;
        if(arr[ind] <= T) take = 1+ rec(ind, T-arr[ind], arr);

        return Math.min(take , notTake);
    }



    public static int memo(int ind, int T, int[]arr, int[][]dp){
        if(ind == 0){
            if(T % arr[0] == 0) return T/arr[0];
            else return (int)1e9;
        }
        if(dp[ind][T] != -1) return dp[ind][T];

        int notTake = memo(ind-1, T, arr, dp);
        int take = Integer.MAX_VALUE;;
        if(arr[ind] <= T) take = 1+ memo(ind, T-arr[ind], arr, dp);

        return dp[ind][T] = Math.min(take , notTake);
    }


    public static int tabu(int[]arr, int target){
        int n = arr.length;
        int[][]dp = new int[n][target+1];

        for(int i=0; i<= target; i++){
            if(i % arr[0] == 0) dp[0][i] = i/arr[0];
            else dp[0][i] =(int) 1e9;
        }

        for(int ind = 1; ind<n; ind++){
            for(int T= 0; T<=target; T++){

                int notTake = 0 + dp[ind-1][T];
                int take = Integer.MAX_VALUE;
                if(arr[ind] <= T) take = 1+ dp[ind][T-arr[ind]];

                dp[ind][T] = Math.min(take, notTake);
            }
        }

        // for(int[]x : dp) System.out.println(Arrays.toString(x));
        return dp[n-1][target];
    }


    public static int space(int[]arr, int target){
        int n = arr.length;
        int[]prev = new int[target+1];

        for(int i=0; i<= target; i++){
            if(i % arr[0] == 0) prev[i] = i/arr[0];
            else prev[i] = (int) 1e9;
        }

        for(int ind = 1; ind<n; ind++){
            int[]temp = new int[target+1];
            for(int T= 0; T<=target; T++){

                int notTake = 0 + prev[T];
                int take = Integer.MAX_VALUE;
                if(arr[ind] <= T) take = 1+ temp[T-arr[ind]];

                temp[T] = Math.min(take, notTake);
            }
            prev = temp;
        }
        return prev[target];
    }



    public static int coinChange(int[] coins, int amount){
        int n = coins.length;

        // int ans = rec(n-1, amount, coins);        //recursion
        // return (ans >= 1e9) ? -1 : ans;


        // int[][]dp = new int[n][amount+1];
        // for(int[]x : dp) Arrays.fill(x, -1);
        // int ans = memo(n-1, amount, coins, dp);   //memoization
        // for(int[]x : dp) System.out.println(Arrays.toString(x));
        // return (ans >= 1e9) ? -1 : ans;

        // int ans = tabu(coins, amount);  //tabulation
        // return (ans >= 1e9) ? -1 : ans;

        int ans = space(coins, amount);   //space optimization
        return (ans >= 1e9) ? -1 : ans;
    }


    public static void main(String[] args) {

    }
}
