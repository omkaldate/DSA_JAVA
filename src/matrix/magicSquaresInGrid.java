package matrix;

import java.util.HashSet;

public class magicSquaresInGrid {
    public static int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        if (n < 3 || m < 3)return ans;

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (isMagicSquare(grid, i, j)) ans++;
            }
        }
        return ans;
    }

    private static boolean isMagicSquare(int[][] grid, int row, int col) {
        HashSet<Integer> set = new HashSet<>();
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag1 = 0, diag2 = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[row + i][col + j];

                if (val < 1 || val > 9 || !set.add(val))return false;

                rows[i] += val;
                cols[j] += val;

                if (i == j) diag1 += val;

                if (i + j == 2) diag2 += val;
            }
        }
        return rows[0] == rows[1] && rows[1] == rows[2] && cols[0] == cols[1] && cols[1] == cols[2] && diag1 == diag2 && diag1 == rows[0];
    }


    public static void main(String[] args) {
        int[][] x = {
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        };
        System.out.println(numMagicSquaresInside(x));
    }
}
