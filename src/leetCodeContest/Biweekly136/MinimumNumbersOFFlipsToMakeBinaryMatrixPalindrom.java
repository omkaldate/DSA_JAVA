package leetCodeContest.Biweekly136;

public class MinimumNumbersOFFlipsToMakeBinaryMatrixPalindrom {
    public static int checkr(int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int ans =0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m/2; j++){
                if(grid[i][j] != grid[i][m-j-1]) ans++;
            }
        }
        return ans;
    }


    public static int checkc(int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int ans =0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n/2; j++){
                if(grid[j][i] != grid[n - j - 1][i]) ans++;
            }
        }
        return ans;
    }


    public static int minFlips(int[][] grid) {
        return Math.min(checkr(grid) , checkc(grid));
    }

    public static void main(String[] args) {
        int[][]ans = {
                {0,1},
                {0,1},
                {0,0}
        };
        System.out.println(minFlips(ans));
    }
}
