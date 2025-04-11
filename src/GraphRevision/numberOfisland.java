package GraphRevision;

import java.util.LinkedList;
import java.util.Queue;

public class numberOfisland {

    public static void bfs(char[][]grid,int i, int j, int[][]side) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{i,j});
        grid[i][j] = '2';

        while(!qu.isEmpty()){
            int[]arr = qu.poll();
            int r = arr[0];
            int c = arr[1];

            for(int[] x : side){
                int row = r + x[0];
                int col = c + x[1];

                if(row >=n || row<0 || col <0 || col >=m) continue;
                if(grid[row][col] == '1'){
                    grid[row][col] = '2';
                    qu.offer(new int[]{row,col});
                }
            }
        }

    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][]side = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid,i, j,side);
                    cnt++;
                }
            }
        }
        return cnt;
    }



    public static void main(String[] args) {
        char[][]grid = {
                {},
                {},
                {}
        };
    }
}
