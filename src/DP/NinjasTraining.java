package DP;

import java.util.Arrays;

public class NinjasTraining {

    public static int rec(int day, int skip, int[][]arr){
        if(day == 0){
            int maxi = 0;
            for(int i=0; i<=2; i++){
                if(i != skip) maxi = Math.max(maxi,arr[day][i]);
            }
            return maxi;
        }

        int maxi = 0;
        for(int i=0; i<=2; i++){
            if(i != skip) {
                int points = arr[day][i] + rec(day-1,i,arr);
                maxi = Math.max(maxi,points);
            }
        }
        return maxi;
    }


    public static int memo(int day , int skip, int[][]arr, int[][]dp){
        if(day == 0){
            int maxi = 0;
            for(int i=0; i<=2; i++){
                if(i != skip) maxi = Math.max(maxi,arr[day][i]);
            }
            return maxi;
        }

        if(dp[day][skip] != -1) return dp[day][skip];

        int maxi = 0;
        for(int i=0; i<=2; i++){
            if(i != skip) {
                int points = arr[day][i] + memo(day-1,i,arr,dp);
                maxi = Math.max(maxi,points);
            }
        }
        return dp[day][skip] = maxi;
    }


    public static int tabu(int[][]arr){
        int n = arr.length;
        int[][]dp = new int[n][4];

        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][0],arr[0][1]);
        dp[0][3] = Math.max(arr[0][2],Math.max(arr[0][0],arr[0][1]));

        for(int day =1; day <n; day++){
            for(int skip=0; skip<=3; skip++){

                for(int i=0; i<=2; i++) {
                    if (i != skip) {
                        int points = arr[day][i] + dp[day - 1][i];
                        dp[day][skip] = Math.max(dp[day][skip], points);
                    }
                }
            }
        }
        return dp[n-1][3];
    }


    public static void main(String[] args) {
        int[][]train = {
                {2,1,3},
                {3,4,6},
                {10,1,6},
                {8,3,7}
        };

        int n = train.length;
        //System.out.println(rec(n-1,3,train)); // recursion

//        int[][]dp = new int[n][n];            //memoization
//        for(int[]x : dp) Arrays.fill(x,-1);
//        memo(n-1,3,train,dp);
//        System.out.println(dp[n-1][n-1]);


        System.out.println(tabu(train));
    }
}
