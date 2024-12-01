package DP;

public class EditDistance {

    public static int rec(int i, int j, String s1, String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)) return rec(i-1, j-1, s1, s2);

        int ins = 1+ rec(i, j-1, s1, s2);
        int del = 1+ rec(i-1, j, s1, s2);
        int repla = 1+ rec(i-1, j-1, s1, s2);

        return Math.min(ins, Math.min(del,repla));
    }


    public static int memo(int i, int j, String s1, String s2, int[][]dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = memo(i-1, j-1, s1, s2, dp);

        int ins = 1+ memo(i, j-1, s1, s2, dp);
        int del = 1+ memo(i-1, j, s1, s2, dp);
        int repla = 1+ memo(i-1, j-1, s1, s2, dp);

        return dp[i][j] = Math.min(ins, Math.min(del,repla));
    }


    public static int tabu(int n, int m, String s1, String s2){
        int[][]dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0] = i;
        for(int j=0; j<=m; j++) dp[0][j] = j;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    int ins = 1 + dp[i][j-1];
                    int del = 1 + dp[i-1][j];
                    int repl = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(ins, Math.min(del,repl));
                }
            }
        }

        return dp[n][m];
    }


    public static int space(int n, int m, String s1, String s2){
        int[]prev = new int[m+1];
        for(int j=0; j<=m; j++) prev[j] = j;

        for(int i=1; i<=n; i++){
            int[]cur = new int[m+1];
            cur[0] = i;
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) cur[j] = prev[j-1];
                else{
                    int ins = 1 + cur[j-1];
                    int del = 1 + prev[j];
                    int repl = 1 + prev[j-1];

                    cur[j] = Math.min(ins, Math.min(del,repl));
                }
            }
            prev = cur;
        }

        return prev[m];
    }



    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // return rec(n-1, m-1, word1, word2);   // recursion


        // int[][]dp = new int[n][m];
        // for(int[]x : dp) Arrays.fill(x,-1);
        // return memo(n-1, m-1, word1, word2, dp);  // memoization

        //return tabu(n, m, word1, word2);   // tabulation

        return space(n,m,word1,word2);
    }




    public static void main(String[] args) {

    }
}
