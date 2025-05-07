package dpRewise;
import java.util.Arrays;

public class Fibonacci {

    public static int rec(int n){
        if(n == 0 || n == 1) return n;
        return rec(n-1) + rec(n-2);
    }

    public static int memo(int n, int[]dp){
        if(n == 0 || n == 1 ) return n;
        if(dp[n] != -1) return dp[n];

        return dp[n] = memo(n-1, dp) + memo(n-2,dp);
    }

    public static int tabu(int n){
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int space(int n){
        int prev1 = 0;
        int prev = 1;

        for(int i=2; i<=n; i++){
            int cur = prev + prev1;
            prev1 = prev;
            prev = cur;
        }
        return prev;
    }



    public static void main(String[] args) {
        int n = 7;

        //int ans = rec(n);

//        int[]dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        int ans = memo(n,dp );

      //  int ans = tabu(n);
        int ans = space(n);
        System.out.println(ans);
    }
}
