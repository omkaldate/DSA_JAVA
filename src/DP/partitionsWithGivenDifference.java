package DP;

public class partitionsWithGivenDifference {
    static int mod =(int)(Math.pow(10,9)+7);

    public static int rec(int ind, int tar, int[]arr){
        if(ind == 0){
            if(tar ==0 && arr[0] == 0) return 2;
            if(tar == 0 || arr[0]==tar) return 1;
            return 0;
        }

        int notTake = rec(ind-1,tar,arr);
        int take = 0;
        if(arr[ind] <= tar) take = rec(ind-1,tar-arr[ind],arr);

        return (notTake + take) % mod;
    }



    public static int memo(int ind, int tar, int[]arr, int[][]dp){
        if(ind == 0){
            if(tar ==0 && arr[0] == 0) return 2;
            if(tar == 0 || arr[0]==tar) return 1;
            return 0;
        }
        if(dp[ind][tar] != -1) return dp[ind][tar];

        int notTake = memo(ind-1,tar,arr,dp);
        int take = 0;
        if(arr[ind] <= tar) take = memo(ind-1,tar-arr[ind],arr,dp);

        return dp[ind][tar] = (notTake + take) % mod;
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

                dp[ind][target]= (notTaken + taken)%mod;
            }
        }
        return dp[n-1][tar];
    }




    public static int space( int tar, int[]num){
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

                temp[target]= (notTaken + taken)%mod;
            }
            prev = temp;
        }
        return prev[tar];
    }


    public static int countPartitions(int n, int d, int[] arr) {
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;

        int s2 = (totSum-d)/2;

        // return rec(n-1,s2,arr);      // recursion

        // int[][]dp = new int[n][s2+1];    //memoization

        // for(int row[]: dp)
        // Arrays.fill(row,-1);

        // return memo(n-1,s2,arr,dp);

        // return tabu(n, s2, arr);      //tabulation

        return space(s2,arr);

    }



    public static void main(String[] args) {

    }
}
