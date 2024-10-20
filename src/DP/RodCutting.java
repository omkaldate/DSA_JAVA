package DP;

import java.util.Arrays;

public class RodCutting {

    public static int rec(int ind, int N, int[]price){
        if(ind == 0) return N*price[0];

        int notTake = rec(ind-1, N, price);
        int take = Integer.MIN_VALUE;
        int rodLength = ind+1;

        if(rodLength <= N) take = price[ind] + rec(ind, N-rodLength, price);

        return Math.max(take , notTake);
    }



    public static int memo(int ind, int N, int[]price, int[][]dp){
        if(ind == 0) return N*price[0];

        if(dp[ind][N] != -1) return dp[ind][N];

        int notTake = memo(ind-1, N, price,dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind+1;

        if(rodLength <= N) take = price[ind] + memo(ind, N-rodLength, price,dp);

        return dp[ind][N] =  Math.max(take , notTake);
    }



    public static int tabu(int len, int N, int[]price){
        int[][]dp =  new int[len][N+1];

        for(int i=0; i<=N; i++) dp[0][i] = i*price[0];

        for(int ind =1; ind<len; ind++){
            for(int cut =0; cut<=N; cut++){

                int notTake = dp[ind-1][cut];
                int take = Integer.MIN_VALUE;
                int rodleng = ind+1;

                if(rodleng <= cut) take = price[ind] + dp[ind][cut-rodleng];

                dp[ind][cut] = Math.max(take, notTake);
            }
        }
        for(int[]x : dp) System.out.println(Arrays.toString(x));
        return dp[len-1][N];
    }




    public static int space(int len, int N, int[]price){
        int[]prev =  new int[N+1];

        for(int i=0; i<=N; i++) prev[i] = i*price[0];

        for(int ind =1; ind<len; ind++){
            int[]temp = new int[N+1];
            for(int cut =0; cut<=N; cut++){

                int notTake = prev[cut];
                int take = Integer.MIN_VALUE;
                int rodleng = ind+1;

                if(rodleng <= cut) take = price[ind] + temp[cut-rodleng];

                temp[cut] = Math.max(take, notTake);
            }
            prev = temp;
        }
        return prev[N];
    }



    public static int spaceExtr(int len, int N, int[]price){
        int[]prev =  new int[N+1];

        for(int i=0; i<=N; i++) prev[i] = i*price[0];

        for(int ind =1; ind<len; ind++){
            for(int cut =0; cut<=N; cut++){

                int notTake = prev[cut];
                int take = Integer.MIN_VALUE;
                int rodleng = ind+1;

                if(rodleng <= cut) take = price[ind] + prev[cut-rodleng];

                prev[cut] = Math.max(take, notTake);
            }
        }
        return prev[N];
    }





    public static int cutRod(int price[], int n) {
        int m = price.length;

        //   return rec(m-1, n, price);    //recursion

        //   int[][]dp = new int[m][n+1];       //memoization
        //   for(int[]x : dp) Arrays.fill(x, -1);
        //   return memo(m-1, n, price, dp);

        // return tabu(m, n, price);       //tabulation

        // return space(m , n, price);  //spaceoptimization

        return spaceExtr(m , n, price);  // Extra spaceoptimization
    }


    public static void main(String[] args) {

    }
}
