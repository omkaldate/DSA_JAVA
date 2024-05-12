package matrix;

import java.util.Arrays;

public class largestLocalValueInMatrix {
    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        int x = 0, y = 0;

        int i1 = 0, j1 = 2;
        int i2 = 0, j2 = 2;

        while(j2 < n){
            i1 = 0;
            j1 = 2;
            while(j1 < n) {
                int maxi = 0;
                for(int i = i2; i <= j2; i++) {
                    for(int j = i1; j <= j1; j++) {
                        maxi = Math.max(maxi, grid[i][j]);
                    }
                }

                i1++;
                j1++;
                ans[x][y] = maxi;
                y++;
            }
            x++;
            y = 0;
            i2++;
            j2++;
        }

        return ans;
    }


    public static void main(String[] args){
        int[][]arr = {
                {9,9,8,1},
                {5,6,2,1},
                {8,2,6,4},
                {6,2,2,2}
        };
        int[][]x = largestLocal(arr);

        for(int[] i: x){
            for(int ch: i){
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
