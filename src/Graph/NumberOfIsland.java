package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {

    static class pair{
        int r;
        int c;
        public pair(int r , int c){
            this.r = r;
            this.c = c;
        }
    }


    public static void BFS(int r , int c, char[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(r,c));
        int[][]direc = {{0,-1},{-1,0},{0,+1},{1,0}};

        while(!q.isEmpty()){
            pair p = q.poll();
            int row = p.r;
            int col = p.c;

            for(int[] arr : direc){
                int dx = row+arr[0];
                int dy = col+arr[1];
                if(dx <0 || dx>=n || dy<0 || dy>=m ) continue;
                if(grid[dx][dy] == '1'){
                    q.offer(new pair(dx,dy));
                    grid[dx][dy] = '0';
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int cnt =0;

        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1'){
                    BFS(i,j,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        char[][]island = {
                {'1','1','1','1'},
                {'0','0','1','0'},
                {'1','0','0','0'},
                {'0','0','1','1'}
        };
        System.out.println(numIslands(island));
    }
}
