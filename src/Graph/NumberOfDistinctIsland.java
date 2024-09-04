package Graph;

import java.util.ArrayList;
import java.util.HashSet;


public class NumberOfDistinctIsland {
    public static String convertItoS(int r, int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    public static void DFS(int row, int col, int[][]vis, int[][]grid, ArrayList<String> list, int baseRo, int baseCo){
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;
        list.add(convertItoS(row-baseRo , col-baseCo));

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for(int i=0; i<4; i++){
            int r = row + dx[i];
            int c = col + dy[i];
            if(r<0 || r >= n || c<0 || c>=m) continue;
            if(grid[r][c] == 1 && vis[r][c] == 0){
                DFS(r,c,vis,grid,list,baseRo,baseCo);
            }
        }
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][]vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] ==0 && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    DFS(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        int[][]arr = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        System.out.println(countDistinctIslands(arr));
    }
}
