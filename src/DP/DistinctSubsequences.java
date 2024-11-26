package DP;

public class DistinctSubsequences {

    public static int rec(int i, int j, String s1, String s2){
        if(j<0) return 1;
        if(i<0) return 0;

        if(s1.charAt(i) == s2.charAt(j)){
            return rec(i-1, j-1, s1, s2) + rec(i-1, j, s1, s2);
        }
        else{
            return rec(i-1, j, s1, s2);
        }
    }


    public static int memo(int i, int j, String s1, String s2, int[][]dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = memo(i-1, j-1, s1, s2, dp) + memo(i-1, j, s1, s2, dp);
        }
        else{
            return dp[i][j] = memo(i-1, j, s1, s2, dp);
        }
    }



    public static int tabu(int n, int m, String s1, String s2){
        int[][]dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }



    public static int space(int n, int m, String s1, String s2){
        int[]prev = new int[m+1];
        prev[0] =1;

        for(int i=1; i<=n; i++){
            int[]cur = new int[m+1];
            cur[0] = 1;
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cur[j] = prev[j-1] + prev[j];
                }
                else{
                    cur[j] = prev[j];
                }
            }
            prev = cur;
        }

        return prev[m];
    }



    public static int onr(int n, int m, String s1, String s2){
        int[]prev = new int[m+1];
        prev[0] =1;

        for(int i=1; i<=n; i++){
            for(int j=m; j>=1; j--){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    prev[j] = prev[j-1] + prev[j];
                }
                else{
                    prev[j] = prev[j];
                }
            }
        }

        return prev[m];
    }



    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        // return rec(n-1, m-1, s, t);   // recursion

        //    int[][]dp = new int[n][m];       // memoization
        //    for(int[]x : dp) Arrays.fill(x,-1);
        //    memo(n-1, m-1, s, t, dp);
        //    return dp[n-1][m-1];


        //return tabu(n, m, s, t);          // tabulation

        // return space(n, m, s, t);         // spaceoptimizatio

        return onr(n, m, s, t);     // 1 row space optimization
    }


    public static void main(String[] args) {
        
    }
}
