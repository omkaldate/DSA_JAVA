package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountSubislands {

    static class tuple {
        int row;
        int col;

        tuple(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

        public static boolean check(int rowx, int colx, int[][] grid2, int[][] grid1) {
            int r = grid2.length;
            int c = grid2[0].length;

            Queue<tuple> q = new LinkedList<>();
            List<tuple> list = new ArrayList<>();
            q.offer(new tuple(rowx, colx));

            while (!q.isEmpty()) {
                tuple tp = q.poll();
                list.add(tp);
                int row = tp.row;
                int col = tp.col;

                if (col > 0 && grid2[row][col - 1] == 1){
                    q.offer(new tuple(row, col - 1));
                    grid2[row][col-1] = 0;
                }
                if (col < c - 1 && grid2[row][col + 1] == 1){
                    q.offer(new tuple(row, col + 1));
                    grid2[row][col + 1] = 0;
                }
                if (row > 0 && grid2[row - 1][col] == 1){
                    q.offer(new tuple(row - 1, col));
                    grid2[row - 1][col] = 0;
                }
                if (row < r - 1 && grid2[row + 1][col] == 1){
                    q.offer(new tuple(row + 1, col));
                    grid2[row + 1][col] = 0;
                }
            }

            return helper(list, grid1);
        }

        public static boolean helper(List<tuple> lis, int[][] grid1) {

            for (int i = 0; i < lis.size(); i++) {
                tuple tp = lis.get(i);
                int row = tp.row;
                int col = tp.col;

                if (grid1[row][col] == 0) return false;
            }
            return true;
        }

        public static int countSubIslands(int[][] grid1, int[][] grid2) {
            int r = grid2.length;
            int c = grid2[0].length;
            int ans = 0;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid2[i][j] == 1) {
                        boolean x = check(i, j, grid2, grid1);
                        if (x) ans++;
                    }
                }
            }
            return ans;
        }


    public static void main(String[] args) {
        int[][]grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };

        int[][]grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

        System.out.println(countSubIslands(grid1,grid2));
    }
}
