package DP;

public class CountSubsetsWithSumK {

    static final int MOD = 1000000007;

    public static int rec(int ind, int target, int[]arr){
        if(ind == 0){
            if(target ==0 && arr[0] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }


        int notTake = rec(ind-1,target,arr);
        int take =0;
        if(arr[ind] <= target) take = rec(ind-1,target-arr[ind],arr);

        return (notTake+take) % MOD;
    }


    public static int memo(int ind, int target, int[] arr, int[][] dp) {
        if(ind == 0){
            if(target ==0 && arr[0] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            return 0;
        }
        if (dp[ind][target] != -1) return dp[ind][target];

        int notTaken = memo(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target) taken = memo(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = (notTaken + taken) %MOD;
    }


    public static int tabu(int n, int tar, int[]num){
        int[][]dp = new int[n][tar+1];

        if(num[0] == 0) dp[0][0] =2;
        else dp[0][0] = 1;
        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;

        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){

                int notTaken = dp[ind-1][target];
                int taken = 0;
                if(num[ind]<=target) taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= (notTaken + taken)% MOD;
            }
        }
        return dp[n-1][tar];
    }



    public static int space(int tar, int[]num){
        int n = num.length;

        int[]prev = new int[tar+1];

        if(num[0] == 0) prev[0] =2;
        else prev[0] = 1;
        if(num[0]!=0 && num[0]<=tar) prev[num[0]] = 1;

        for(int ind = 1; ind<n; ind++){
            int[]temp = new int[tar+1];
            for(int target= 0; target<=tar; target++){

                int notTaken = prev[target];
                int taken = 0;
                if(num[ind]<=target) taken = prev[target-num[ind]];

                temp[target]= (notTaken + taken)%MOD;
            }
            prev = temp;
        }
        return prev[tar];
    }


    public static int perfectSum(int arr[],int n, int sum) {
        //return rec(n-1,sum,arr);       //recursion

        //   int[][]dp = new int[n][sum+1];        //memoization
        //   for(int[]x : dp) Arrays.fill(x,-1);

        //   return memo(n-1, sum, arr, dp);

        //return tabu(n, sum, arr);   //tabulation

        return space(sum,arr);
    }




    public static void main(String[] args) {

    }
}
