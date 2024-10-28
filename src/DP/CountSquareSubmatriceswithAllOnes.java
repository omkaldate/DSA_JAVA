package DP;

public class CountSquareSubmatriceswithAllOnes {

    //memoization
    static int m, n;
     private static int solve(int i, int j, int[][] grid, int[][] t) {
         if (i >= grid.length || j >= grid[0].length) return 0;
         if (grid[i][j] == 0)return 0;

         if (t[i][j] != -1)return t[i][j];

         int right = solve(i, j + 1, grid, t);
         int diagonal = solve(i + 1, j + 1, grid, t);
         int below = solve(i + 1, j, grid, t);

         return t[i][j] = 1 + Math.min(Math.min(right, diagonal), below);
     }

     public static int countSquares(int[][] grid) {
         int result = 0;
         m = grid.length;
         n = grid[0].length;
         int[][] t = new int[m][n];
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 t[i][j] = -1;
             }
         }
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 result += solve(i, j, grid, t);
             }
         }
         return result;
     }



//tabulation
    public static int countSquare(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
                result += dp[i][j];
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
