package DP;

public class LongestcommonSubsequence {

    public static int rec(int n, int m, String text1, String text2){
        if(n<0 || m <0) return 0;

        if(text1.charAt(n) == text2.charAt(m)) return 1+ rec(n-1, m-1, text1, text2);

        return Math.max(rec(n-1,m,text1,text2), rec(n,m-1,text1,text2));
    }



    public static int memo(int n, int m, String text1, String text2, int[][]dp){
        if(n<0 || m <0) return 0;
        if(dp[n][m] != -1) return dp[n][m];

        if(text1.charAt(n) == text2.charAt(m)) return 1+ memo(n-1, m-1, text1, text2,dp);

        return dp[n][m] =  Math.max(memo(n-1,m,text1,text2,dp), memo(n,m-1,text1,text2,dp));
    }


    public static int tabu(int n, int m, String s1, String s2){
        int[][]dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int j=0; j<=m; j++) dp[0][j] = 0;

        for(int i=1; i<= n; i++){
            for(int j=1; j<=m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[n][m];
    }


    public static int space(int n, int m, String s1, String s2){
        int[]prev = new int[m+1];
        for(int j=0; j<=m; j++) prev[j] = 0;

        for(int i=1; i<= n; i++){
            int[]cur = new int[m+1];
            for(int j=1; j<=m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)) cur[j] = 1 + prev[j-1];
                else cur[j] = Math.max(prev[j] , cur[j-1]);
            }
            prev = cur;
        }
        return prev[m];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        //return rec(n-1, m-1, text1, text2);    //recursion

        // int[][]dp = new int[n][m];         //memoization
        // for(int[]x : dp) Arrays.fill(x,-1);
        // return memo(n-1,m-1,text1,text2,dp);


        //return tabu(n,m,text1,text2);      //tabulation

        return space(n,m,text1,text2);     //space
    }


    
    public static void main(String[] args) {

    }
}
