package ATest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BNY_1 {

    public static int maxPathSum(List<List<Integer>> board, int p, int q) {
        int n = board.size();
        int m = board.get(0).size();

        // Initialize dp arrays
        int[][] dp_top = new int[n][m];
        int[][] dp_bottom = new int[n][m];

        // Initialize the starting positions
        dp_top[0][p] = board.get(0).get(p);
        dp_bottom[n-1][q] = board.get(n-1).get(q);

        // Fill dp_top
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxPrev = dp_top[i-1][j];
                if (j > 0) {
                    maxPrev = Math.max(maxPrev, dp_top[i-1][j-1]);
                }
                if (j < m - 1) {
                    maxPrev = Math.max(maxPrev, dp_top[i-1][j+1]);
                }
                dp_top[i][j] = board.get(i).get(j) + maxPrev;
            }
        }

        // Fill dp_bottom
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int maxNext = dp_bottom[i+1][j];
                if (j > 0) {
                    maxNext = Math.max(maxNext, dp_bottom[i+1][j-1]);
                }
                if (j < m - 1) {
                    maxNext = Math.max(maxNext, dp_bottom[i+1][j+1]);
                }
                dp_bottom[i][j] = board.get(i).get(j) + maxNext;
            }
        }

        // Find the maximum score possible from either starting point
        int maxScore = 0;
        for (int j = 0; j < m; j++) {
            maxScore = Math.max(maxScore, dp_top[n-1][j]);
            maxScore = Math.max(maxScore, dp_bottom[0][j]);
        }

        return maxScore;
    }



    public static void main(String[] args) {
        List<List<Integer>> board = List.of(
                List.of(9,4,7),
                List.of(2,1,3),
                List.of(1,4,2)
        );
        int p = 2;
        int q = 1;

        System.out.println(maxPathSum(board, p, q));  // Output: 17
    }
}
