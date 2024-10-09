package DP;

public class MinimumFallingPathSum {

    public static int rec(int i, int j, int[][]arr){
        if(j<0 || j>= arr[0].length) return (int) 1e9;
        if(i == 0) return arr[i][j];

        int str = arr[i][j] + rec(i-1,j,arr);
        int lef = arr[i][j] + rec(i-1,j-1,arr);
        int rig = arr[i][j] + rec(i-1,j+1,arr);

        return Math.min(str, Math.min(lef,rig));
    }


    public static int memo(int i, int j, int[][]arr, int[][]dp){
        if(j<0 || j>= arr[0].length) return (int) 1e9;
        if(i == 0) return arr[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int str = arr[i][j] + memo(i-1,j,arr,dp);
        int lef = arr[i][j] + memo(i-1,j-1,arr,dp);
        int rig = arr[i][j] + memo(i-1,j+1,arr,dp);

        return dp[i][j] = Math.min(str, Math.min(lef,rig));
    }


    public static int tabu(int[][]arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][]dp = new int[n][m];
        for(int x=0; x<m; x++){
            dp[0][x] = arr[0][x];
        }

        for(int i=1; i<n; i++){
            for(int j =0; j<m; j++){
                int str = arr[i][j] + dp[i-1][j];
                int lef = Integer.MAX_VALUE;
                int rig = Integer.MAX_VALUE;
                if(j-1 >=0){
                    lef = arr[i][j];
                    lef+= dp[i-1][j-1];
                }
                if(j+1 <m){
                    rig = arr[i][j];
                    rig+= dp[i-1][j+1];
                }

                dp[i][j] = Math.min(str, Math.min(lef,rig));
            }
        }

        int ans = dp[n-1][0];
        for(int x=1; x<m; x++){
            ans = Math.min(ans,dp[n-1][x]);
        }

        return ans;
    }


    public static int space(int[][]arr){
        int n = arr.length;
        int m = arr[0].length;

        int[]prev = new int[m];
        for(int x=0; x<m; x++){
            prev[x] = arr[0][x];
        }

        for(int i=1; i<n; i++){
            int[]temp = new int[m];
            for(int j =0; j<m; j++){
                int str = arr[i][j] + prev[j];
                int lef = Integer.MAX_VALUE;
                int rig = Integer.MAX_VALUE;
                if(j-1 >=0){
                    lef = arr[i][j];
                    lef+= prev[j-1];
                }
                if(j+1 <m){
                    rig = arr[i][j];
                    rig+= prev[j+1];
                }

                temp[j] = Math.min(str, Math.min(lef,rig));
            }
            prev = temp;
        }

        int ans = prev[0];
        for(int x=1; x<m; x++){
            ans = Math.min(ans,prev[x]);
        }

        return ans;
    }


    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // int ans =Integer.MAX_VALUE;           //recursion
        // for(int i=0; i<m; i++){
        //     ans = Math.min(ans, rec(n-1,i,matrix));
        // }
        // return ans;


        // int[][]dp = new int[n][m];
        // for(int[]x : dp) Arrays.fill(x,-1);
        // int ans =Integer.MAX_VALUE;            //memoization
        // for(int i=0; i<m; i++){
        //     ans = Math.min(ans, memo(n-1,i,matrix,dp));
        // }
        // return ans;

        // return tabu(matrix);   //tabulation

        return space(matrix);
    }

    public static void main(String[] args) {

    }
}
