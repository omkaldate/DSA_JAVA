package DP;

import java.util.Arrays;

public class LongestCommonSubString_length {

    // this program is from longest common subsewuence problem from dp 25 striver

    public static int tabu(int n, int m, String s1, String s2){
        int[][]dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int j=0; j<=m; j++) dp[0][j] = 0;

        int ans=0;
        for(int i=1; i<= n; i++){
            for(int j=1; j<=m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = 0;
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        String s1 = "abcdr";
        String s2 = "jabcx";
        int n = s1.length();
        int m = s2.length();

        int ans = tabu(n, m, s1, s2);
        System.out.println(ans);
    }
}
