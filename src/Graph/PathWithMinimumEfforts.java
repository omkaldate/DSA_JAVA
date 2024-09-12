package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEfforts {

    static class Pair {
        int d;
        int r;
        int c;

        Pair(int d , int r , int c){
            this.d = d;
            this.r =  r;
            this.c = c;
        }
    }

    public static int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }
        dist[0][0] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.d - y.d);
        q.offer(new Pair(0,0,0));


        int[]dx = {-1,0,1,0};
        int[]dy = {0,1,0,-1};

        while(! q.isEmpty()){
            Pair p = q.poll();
            int d = p.d;
            int r = p.r;
            int c = p.c;
            if(r == n-1 && c == m-1) return d;

            for(int i=0; i<4; i++){
                int row = r + dx[i];
                int col = c + dy[i];

                if(row < 0 || row >=n || col < 0 || col >=m) continue;
                int newEffort = Math.max(d ,Math.abs(grid[r][c] - grid[row][col]));
                if(newEffort < dist[row][col]){
                    dist[row][col] = newEffort;
                    q.offer(new Pair(newEffort,row,col));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 9, 1},
                {9, 1, 1, 1},
                {1, 1, 9, 9},
                {1, 9, 4, 1}
        };
        System.out.println(minimumEffortPath(arr));
    }
}
