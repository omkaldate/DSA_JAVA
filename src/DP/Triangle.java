package DP;

import java.util.List;

public class Triangle {
    public static int rec(int i, int j, List<List<Integer>> list){
        if(i == list.size()-1) return list.get(i).get(j);

        int down = list.get(i).get(j) + rec(i+1,j,list);
        int digo = list.get(i).get(j) + rec(i+1,j+1,list);

        return Math.min(down,digo);
    }


    public static int memo(int i, int j, List<List<Integer>> list, int[][]dp){
        if(i == list.size()-1) return list.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];

        int down = list.get(i).get(j) + memo(i+1,j,list,dp);
        int digo = list.get(i).get(j) + memo(i+1,j+1,list,dp);

        return dp[i][j] = Math.min(down,digo);
    }

    public static int tabu(List<List<Integer>> list, int[][]dp){
        int n = list.size();
        for(int x=n-1; x>=0; x--){
            dp[n-1][x] = list.get(n-1).get(x);
        }

        for(int i = n-2; i>=0; i--){
            for(int j =i; j>=0; j--){
                int down = list.get(i).get(j) + dp[i+1][j];
                int digo = list.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down,digo);
            }
        }
        return dp[0][0];
    }


    public static int space(List<List<Integer>> list){
        int n = list.size();

        int[]prev = new int[n];

        for(int x=n-1; x>=0; x--){
            prev[x] = list.get(n-1).get(x);
        }

        for(int i = n-2; i>=0; i--){
            int[]temp = new int[i+1];
            for(int j =i; j>=0; j--){
                int down = list.get(i).get(j) + prev[j];
                int digo = list.get(i).get(j) + prev[j+1];
                temp[j] = Math.min(down,digo);
            }
            prev = temp;
        }
        return prev[0];
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //return rec(0,0,triangle);   //recursion

        //int[][]dp = new int[n][n];      //memoization
        // for(int[]x : dp) Arrays.fill(x,-1);
        // return memo(0,0,triangle,dp);

        //    int[][]dp = new int[n][n];      //tabulation
        //    return tabu(triangle,dp);

        return space(triangle);
    }


    public static void main(String[] args) {

    }
}
