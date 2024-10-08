package DP;

public class MinimumPathSum {

    public static int rec(int n, int m, int[][]arr){
        if(n == 0 && m ==0) return arr[0][0];
        if(n<0 || m<0) return (int)Math.pow(10,9);

        int up = arr[n][m] + rec(n-1,m,arr);
        int left = arr[n][m] + rec(n,m-1,arr);

        return Math.min(up,left);
    }



    public static int memo(int n, int m, int[][]arr, int[][]dp){
        if(n == 0 && m ==0) return arr[0][0];
        if(n<0 || m<0) return (int)Math.pow(10,9);
        if(dp[n][m] != -1) return dp[n][m];

        int up = arr[n][m] + memo(n-1,m,arr,dp);
        int left = arr[n][m] + memo(n,m-1,arr,dp);

        return dp[n][m] =  Math.min(up,left);
    }

    public static int tabu(int n , int m, int[][]arr){
        int[][]dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j ==0){
                    dp[0][0] = arr[0][0];
                    continue;
                }

                int down = arr[i][j];
                if(i>0) down += dp[i-1][j];
                else down += (int) 1e9;

                int right =arr[i][j];
                if(j>0) right += dp[i][j-1];
                else right += (int) 1e9;

                dp[i][j] = Math.min(right,down);
            }
        }
        return dp[n-1][m-1];
    }


    public static int space(int n, int m, int[][]arr){
        int[] prev = new int[m];

        for(int i=0; i<n; i++){
            int[] temp = new int[m];

            for(int j=0; j<m; j++){
                if(i==0 && j == 0){
                    temp[0] = arr[0][0];
                    continue;
                }

                int down = arr[i][j];
                if(i>0) down += prev[j];
                else down += (int) 1e9;

                int right =arr[i][j];
                if(j>0) right += temp[j-1];
                else right += (int) 1e9;

                temp[j] = Math.min(right,down);
            }
            prev = temp;
        }
        return prev[m-1];
    }




    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // return rec(n-1,m-1,grid);    //recursion

        //    int[][]dp = new int[n][m];        //memoization
        //    for(int[]x : dp) Arrays.fill(x,-1);
        //    return memo(n-1,m-1,grid,dp);

        //return tabu(n,m,grid);     //tabulation

        return space(n,m,grid);
    }


    public static void main(String[] args) {

    }
}
