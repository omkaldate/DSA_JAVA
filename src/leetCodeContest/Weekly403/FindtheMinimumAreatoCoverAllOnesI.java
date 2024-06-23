package leetCodeContest.Weekly403;

import java.util.HashSet;
import java.util.Set;

public class FindtheMinimumAreatoCoverAllOnesI {
    public static int minimumArea(int[][] grid) {

        Set<Integer> rs = new HashSet<>();
        Set<Integer> cs = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rs.add(i);
                    cs.add(j);
                }
            }
        }

        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        for (int row : rs) {
            if (row < minRow) minRow = row;
            if (row > maxRow) maxRow = row;
        }

        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for (int col : cs) {
            if (col < minCol) minCol = col;
            if (col > maxCol) maxCol = col;
        }

        int area = (maxRow - minRow + 1) * (maxCol - minCol + 1);
        return area;
    }


    public static void main(String[] args){
        int [][]arr ={
                {0,1,1,0,0},
                {0,0,1,0,0},
                {1,0,1,0,0}
        };
        System.out.println(minimumArea(arr));
    }
}
