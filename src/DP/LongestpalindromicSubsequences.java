package DP;

public class LongestpalindromicSubsequences {

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


    public static void main(String[] args) {
        String s1 = "bbabcbcbac";
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length();

        int ans = tabu(n,n,s1,s2);
        System.out.println(ans);
    }
}
