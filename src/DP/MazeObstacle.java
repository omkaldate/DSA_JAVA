package DP;

public class MazeObstacle {

    public static int rec(int n,int m,int[][]arr){
        if(n>=0 && m>=0 && arr[n][m] == 1) return 0;
        if(n == 0 && m ==0) return 1;
        if(n <0 || m <0) return 0;

        int up = rec(n-1,m,arr);
        int left = rec(n,m-1,arr);
        return up + left;
    }


    public static int memo(int n,int m,int[][]arr,int[][]dp){
        if(n>=0 && m>=0 && arr[n][m] == 1) return 0;
        if(n == 0 && m ==0) return 1;
        if(n <0 || m <0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        int up = memo(n-1,m,arr,dp);
        int left = memo(n,m-1,arr,dp);
        return dp[n][m] =  up + left;
    }



    public static int tabu(int n, int m, int[][]arr){
        int[][]dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (arr[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i==0 && j ==0){
                    dp[i][j] = 1;
                    continue;
                }
                else{
                    int down = 0;
                    int left = 0;
                    if(i>0) down = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = down+left;
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static int space(int n, int m, int[][]arr){
        int[] prev = new int[m];

        for(int i=0; i<n; i++){
            int[]temp = new int[m];
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1){
                    temp[j] = 0;
                    continue;
                }
                if(i==0 && j ==0){
                    temp[j] = 1;
                    continue;
                }
                else{
                    int down = 0;
                    int left = 0;
                    if(i>0) down = prev[j];
                    if(j>0) left = temp[j-1];
                    temp[j] = down+left;
                }
            }
            prev = temp;
        }
        return prev[m-1];
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        //return rec(n-1,m-1,obstacleGrid);    // recursion

        // int[][]dp = new int[n][m];
        // for(int[]x : dp) Arrays.fill(x,-1);    //memoization
        // dp[0][0] = 1;
        // return memo(n-1,m-1,obstacleGrid,dp);

        //return tabu(n,m,obstacleGrid);        //tabulstion

        return space(n,m,obstacleGrid);        // spaceoptimization
    }

    public static void main(String[] args) {

    }
}
