package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Nearest1sDistance {
    static class pair{
        int r;
        int c;
        int d;

        pair(int a, int b , int c){
            this.r = a;
            this.c = b;
            this.d = c;
        }
    }

    public static int[][] updateMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][]matrix = new int[row][col];
        int[][]vis = new int[row][col];

        Queue<pair> q = new LinkedList<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 0){
                    q.offer(new pair(i,j,0));
                    vis[i][j] = 1;
                }

            }
        }

        int[]dx = {-1,0,1,0};
        int[]dy = {0,+1,0,-1};

        while(! q.isEmpty()){
            pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int d = p.d;

            matrix[r][c] = d;


            for(int k=0; k<4; k++){
                int rCell = r+dx[k];
                int cCell = c+dy[k];

                if(rCell <row && rCell >=0 && cCell >=0 && cCell <col && vis[rCell][cCell] == 0){

                    vis[rCell][cCell] = 1;
                    q.add(new pair(rCell,cCell,d+1));
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][]arr = {
                {0,0,0,},
                {0,1,0,},
                {1,1,1}
        };

        int[][]arr2 = updateMatrix(arr);

        for(int[]x : arr2){
            System.out.println(Arrays.toString(x));
        }
    }
}
