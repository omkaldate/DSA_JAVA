package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {


    static class Pair{
        int r;
        int c;

        Pair(int a , int b){
            this.r = a;
            this.c = b;
        }
    }


    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                if(i ==0 || j==0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        vis[i][j] = 1;
                        q.offer(new Pair(i,j));
                    }
                }
            }
        }

        int[]dx = {-1,0,1,0};
        int[]dy = {0,1,0,-1};

        while(! q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;

            for(int i=0; i<4; i++){
                int row = r+dx[i];
                int col = c+dy[i];

                if(row <0 || row >=n || col <0 || col >=m) continue;
                if (grid[row][col] == 1 && vis[row][col] == 0){
                    vis[row][col] = 1;
                    q.offer(new Pair(row, col));
                }
            }
        }

        int cnt =0;
        for(int a=0; a<n; a++){
            for(int b=0; b<m; b++){
                if(grid[a][b] ==1 && vis[a][b] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }



    public static void main(String[] args) {
        int[][]grid = {
                {0,0,0,1,1},
                {0,0,1,1,0},
                {0,1,0,0,0},
                {0,1,1,0,0},
                {0,0,0,1,1}
        };
        System.out.println(numEnclaves(grid));
    }
}
