package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNumberofFishinaGrid {
    public static int fun(int i, int j, int[][]vis, int[][]grid){
        int n = grid.length;
        int m = grid[0].length;

        int[]dx = {-1, 0, 1, 0};
        int[]dy = {0, 1, 0, -1};

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{i,j});
        vis[i][j] = 1;
        int ans = grid[i][j];

        while(!qu.isEmpty()){
            int[]arr = qu.poll();

            for(int f=0; f<4; f++){
                int r = arr[0] + dx[f];
                int c = arr[1] + dy[f];

                if(r<0 || r>=n || c<0 || c>=m) continue;
                if(grid[r][c] ==0 || vis[r][c] == 1 ) continue;

                ans += grid[r][c];
                vis[r][c] = 1;

                qu.offer(new int[]{r,c});
            }
        }
        return ans;
    }


    public static  int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][]vis = new int[n][m];

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != 0  && vis[i][j] ==0){
                    ans = Math.max(ans, fun(i,j, vis, grid));
                }
            }
        }
        return ans;
    }





    public static void main(String[] args) {

    }
}
