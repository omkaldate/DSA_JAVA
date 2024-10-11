package DP;

import java.util.ArrayList;

public class PartitionArrayIntoTwoArraystoMinimizeSumDifference {

    static int memo(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        for (int i = 0; i < n; i++) totSum += arr.get(i);

        boolean[][] dp = new boolean[n][totSum + 1];

        for (int i = 0; i <= totSum; i++) dp[0][i] = (i == arr.get(0));


        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= totSum; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }
                dp[ind][target] = notTaken || taken;
            }
        }
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }



    static int tabu(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        for (int i = 0; i < n; i++) totSum += arr.get(i);


        boolean[][] dp = new boolean[n][totSum + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (arr.get(0) <= totSum) dp[0][totSum] = true;


        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }
                dp[ind][target] = notTaken || taken;
            }
        }
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }


    static int space(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        boolean[] prev = new boolean[totSum + 1];

        prev[0] = true;

        if (arr.get(0) <= totSum) {
            prev[arr.get(0)] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[totSum + 1];
            cur[0] = true;
            for (int target = 1; target <= totSum; target++) {
                boolean notTaken = prev[target];
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = prev[target - arr.get(ind)];
                }
                cur[target] = notTaken || taken;
            }
            prev = cur;
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= totSum; i++) {
            if (prev[i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }


    public static void main(String[] args) {

    }
}
