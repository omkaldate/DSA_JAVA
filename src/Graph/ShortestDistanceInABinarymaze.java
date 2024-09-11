package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInABinarymaze {
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

    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]dist = new int[n][m];

        if(source[0] == destination[0] && source[1] == destination[1]) return 0;

        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }

        dist[source[0]][source[1]] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,source[0],source[1]) );


        int[]dx = {-1,0,1,0};
        int[]dy = {0,1,0,-1};

        while(! q.isEmpty()){
            Pair p = q.poll();
            int d = p.d;
            int r = p.r;
            int c = p.c;

            for(int i=0; i<4; i++){
                int row = r + dx[i];
                int col = c + dy[i];

                if(row < 0 || row >=n || col < 0 || col >=m) continue;
                if(grid[row][col] ==1 && d+1 < dist[row][col]){
                    if(row == destination[0] && col == destination[1]) return d+1;
                    dist[row][col] = d+1;
                    q.offer(new Pair(d+1,row,col));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}
        };
        int[] src = {0,1};
        int[] end = {2,2};

        System.out.println(shortestPath(arr,src,end));
    }
}
