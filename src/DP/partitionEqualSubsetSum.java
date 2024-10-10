package DP;

public class partitionEqualSubsetSum {

    public static boolean rec(int ind, int tar, int[]arr){
        if(tar == 0) return true;
        if(ind == 0) return (arr[ind] == tar);

        boolean notTake = rec(ind-1,tar,arr);
        boolean take = false;
        if(arr[ind] <= tar) take = rec(ind-1,tar-arr[ind],arr);

        return (notTake || take);
    }


    public static boolean memo(int ind, int tar, int[]arr, boolean[][]dp){
        if(tar == 0) return true;
        if(ind == 0) return (arr[ind] == tar);
        if(dp[ind][tar]) return dp[ind][tar];

        boolean notTake = memo(ind-1,tar,arr,dp);
        boolean take = false;
        if(arr[ind] <= tar) take = memo(ind-1,tar-arr[ind],arr,dp);

        return dp[ind][tar] = (notTake || take);
    }


    public static boolean tabu(int n, int k, int[] arr) {
        boolean dp[][] = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (arr[0] <= k) dp[0][arr[0]] = true;


        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {

                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = notTaken || taken;
            }
        }
        // for(boolean x[]: dp){
        //     System.out.println(Arrays.toString(x));
        // }
        return dp[n - 1][k];
    }


    public static boolean space(int n, int k, int[] arr) {
        boolean prev[] = new boolean[k + 1];
        prev[0] = true;
        if (arr[0] <= k) prev[arr[0]] = true;


        for (int ind = 1; ind < n; ind++) {
            boolean[] temp = new boolean[k+1];
            temp[0] = true;
            for (int target = 1; target <= k; target++) {

                boolean notTaken = prev[target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                temp[target] = notTaken || taken;
            }
            prev = temp;
        }
        return prev[k];
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) sum += nums[i];
        if(sum %2 !=0) return false;

        int divSum = sum/2;

        // if(rec(n-1,divSum, nums)) return true;   //recursion
        // else return false;

        // boolean[][]dp = new boolean[n][divSum+1]; //memoization
        // if(memo(n-1,divSum, nums,dp)) return true;
        // else return false;

        //    if(tabu(n,divSum, nums)) return true;   //tabulation
        //    else return false;

        if(space(n,divSum, nums)) return true;
        else return false;
    }


    public static void main(String[] args) {

    }
}
