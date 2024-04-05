package recursion;

import java.util.Arrays;

public class printTheMatrixOfThePath {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][]path = new int[board.length][board[0].length];
       backTrack("" , board , 0 ,0 , path , 1);

    }

    static void backTrack(String p ,boolean [][]maze, int r , int c , int [][]path , int step){
        if(r== maze.length-1 && c==maze[0].length-1){
            path[r][c] = step;
            for(int[] i : path){
                System.out.println(Arrays.toString(i));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if(r < maze.length-1){
            backTrack(p+'d' ,maze ,r+1 ,c ,path , step+1);
        }
        if(c < maze.length-1){
            backTrack(p+'r' ,maze , r ,c+1, path , step+1);
        }
        if(r > 0){
            backTrack(p+'u' ,maze , r-1 ,c,path , step+1);
        }
        if(c > 0){
            backTrack(p+'l' ,maze , r ,c-1,path , step+1);
        }
        // This line is where the function will be over
        //so before the function gets removed , also remove the changes that were made by that function
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
