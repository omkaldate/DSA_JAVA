package REVISION.Rrcursion;

public class BackTrackingAllPaths {

    public static void path(boolean[][]maze,int row,int col,String str){
        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.println(str);
            return;
        }

        if(maze[row][col] == false){
            return;
        }

        maze[row][col] = false;

        if(row+1 < maze.length) {
            path(maze, row + 1, col, str + "D");
        }
        if(col+1 < maze[0].length) {
            path(maze, row, col + 1, str + "R");
        }
        if(row-1 >0){
            path(maze,row-1,col,str+"U");
        }
        if(col-1 > 0){
            path(maze,row,col-1,str+"L");
        }

        maze[row][col] = true;
    }



    public static void main(String[] args) {
        boolean[][]maze = {
                {true , true , true},
                {true , true , true},
                {true , true , true}
        };

        path(maze,0,0,"");
    }
}
