package DP;

import java.util.Arrays;

public class TotaluniquePath {

    public static int rec(int i, int j){
        if(i==0 && j == 0) return 1;

        if(i<0 || j<0) return 0;
        int left = rec(i,j-1);
        int right = rec(i-1,j);
        return left + right;
    }

    public static int memo(int i, int j, int[][]dp){
        if(i==0 && j == 0) return 1;

        if(i<0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int left = memo(i,j-1,dp);
        int right = memo(i-1,j,dp);
        return dp[i][j] = left + right;
    }


    public static int tabu(int i , int j){
        int[][]dp = new int[i+1][j+1];
        dp[0][0] = 1;

        for(int x=0; x<=i; x++){
            for(int y=0; y<=j; y++){
                if(x ==0 && y ==0) continue;

                int down =0;
                int right = 0;
                if(x>0)  down = dp[x-1][y];
                if(y>0)  right = dp[x][y-1];

                dp[x][y] = down+right;
            }
        }
        return dp[i][j];
    }


    static int space(int m, int n) {
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            int temp[] = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0) up = prev[j];
                if (j > 0) left = temp[j - 1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }

    public static void main(String[] args) {
       // System.out.println(rec(2,2));  //recursion

//        int[][]dp = new int[3][3];        //memoization
//        for(int[]x : dp) Arrays.fill(x,-1);
//        System.out.println(memo(2,2,dp));

 //       System.out.println(tabu(2,2));    //tabulation

        System.out.println(space(3,3));


    }
}
