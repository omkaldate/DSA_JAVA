package REVISION.Rrcursion;

public class NQueens {

    public static void path(boolean[][]maze , int row){
        if(row == maze.length){
            for(int i=0; i<maze.length; i++){
                for(int j=0; j<maze[0].length; j++){
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int x=0; x<maze.length; x++){
            if(isSafe(maze,row,x)){
                maze[row][x] = false;
                path(maze,row+1);
                maze[row][x] = true;
            }
        }
    }

    public static boolean isSafe(boolean[][]maze,int row,int col){
        for(int i=0; i< row; i++){
            if(maze[i][col] == false) return false;
        }

        int shiftLeft = Math.min(row,col);
        for(int i=0; i<= shiftLeft; i++){
            if(maze[row-i][col-i] == false) return false;
        }

        int shiftRight = Math.min(row,maze.length-1 - col);
        for(int i=0; i<= shiftRight; i++){
            if(maze[row-i][col+i] == false) return false;
        }
        return true;
    }



    public static void main(String[] args) {
        boolean[][]maze = {
                {true , true , true, true},
                {true , true , true, true},
                {true , true , true, true},
                {true , true , true, true}
        };

        path(maze,0);
    }
}
