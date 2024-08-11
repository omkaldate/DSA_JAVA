package HardProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinimumNumberOfDaysToDisconnectIslands {
    int n;
    int m;

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;
        boolean[][] isVisited = new boolean[m][n];
        List<Cell> list = new ArrayList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    list.add(new Cell(i,j));
                }
                if(grid[i][j] == 1 && !isVisited[i][j]){
                    bfs(grid,i,j,isVisited);
                    count++;
                }
            }
        }


        if(count == 0 || count > 1){
            return 0;
        }

        else{
            for(Cell c: list){
                isVisited = new boolean[m][n];
                grid[c.row][c.col] = 0;
                int islandCount = 0;
                for(int i = 0; i<m; i++){
                    for(int j = 0; j<n; j++){
                        if(grid[i][j] == 1 && !isVisited[i][j]){
                            bfs(grid,i,j,isVisited);
                            islandCount++;
                        }
                    }
                }
                grid[c.row][c.col] = 1;

                if(islandCount > 1 || islandCount == 0){
                    return 1;
                }
            }
        }
        return 2;
    }

    public void bfs (int[][] grid, int i, int j, boolean[][] isVisited){

        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};

        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(i,j));

        while(!queue.isEmpty()){
            Cell cell = queue.poll();

            int row = cell.row;
            int col = cell.col;

            for(int k = 0; k<4; k++){
                int r = row + dx[k];
                int c = col + dy[k];
                if(isValid(r,c) && grid[r][c] == 1 && !isVisited[r][c]){
                    queue.add(new Cell(r,c));
                    isVisited[r][c] = true;
                }
            }
        }

    }

    public class Cell{
        int row;
        int col;
        Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public boolean isValid(int i, int j){
        if(i>=0 && i< m && j>=0 && j<n){
            return true;
        }
        return false;
    }






    public static void main(String[] args) {
        MinimumNumberOfDaysToDisconnectIslands obj = new MinimumNumberOfDaysToDisconnectIslands();
        int[][]arr = {
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        System.out.println(obj.minDays(arr));
    }
}
