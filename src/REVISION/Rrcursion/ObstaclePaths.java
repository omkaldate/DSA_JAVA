package REVISION.Rrcursion;

public class ObstaclePaths {

    public static void path(boolean[][]maze,int row,int col,String way){
        if(row==maze.length-1 && maze[col].length-1 == col){
            System.out.println(way);
        }
        if(maze[row][col] == false){
            return;
        }

        if(row+1 < maze.length) {
            path(maze, row + 1, col, way + "D");
        }
        if(col+1 < maze[0].length) {
            path(maze, row, col + 1, way + "R");
        }

    }

    public static void main(String[] args) {
        boolean[][]maze = {
                {true , true , true},
                {true , false , true},
                {true , true , true}
        };

        path(maze,0,0,"");
    }
}
