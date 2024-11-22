package DP;

import java.util.Arrays;

public class LongestCmmonSubSequence_formString {
    // this program is from longest common subsewuence problem from dp 25 striver

    public static void tabu(int n, int m, String s1, String s2){
        int[][]dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int j=0; j<=m; j++) dp[0][j] = 0;

        for(int i=1; i<= n; i++){
            for(int j=1; j<=m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        int len= dp[n][m];


        // real program start from here
        char[] str = new char[len];
        int ind = len-1;

        while(n>0 && m>0){
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                str[ind--] = s1.charAt(n-1);
                n--;
                m--;
            }
            else{
                if(dp[n-1][m] > dp[n][m-1]) n--;
                else m--;
            }
        }

        System.out.println(Arrays.toString(str));
    }


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";
        int n = s1.length();
        int m = s2.length();

        tabu(n, m, s1, s2);
    }
}
