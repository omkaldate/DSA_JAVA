package queue;

import java.util.Deque;
import java.util.LinkedList;

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int minutes = 0;
        int m = grid.length, n = grid[0].length;
        Deque<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) fresh++;
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int[] cur = queue.poll();
                for (int[] d : directions) {
                    int nX = cur[0] + d[0];
                    int nY = cur[1] + d[1];
                    if (nX < 0 || nX >= m || nY < 0 || nY >= n) continue;
                    if (grid[nX][nY] == 1) {
                        grid[nX][nY] = 2;
                        fresh--;
                        queue.add(new int[]{nX, nY});
                    }
                }
                size--;
            }
            minutes++;
        }
        return fresh > 0 ? -1 : Math.max(minutes-1,0);
    }

    public static void main(String[] args) {
        int[][]arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(arr));
    }
}
