package recursion;

import java.util.ArrayList;

public class mazeWithObstracles {
    public static void main(String[] args){
        boolean [][]board = {
                {true ,true, true},
                {true ,false, true},
                {true ,true, true}

        };
      pathrestriction("" ,board ,0 , 0);
    }

    static void pathrestriction(String p ,boolean [][]maze, int r , int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length-1){
            pathrestriction(p+'d' ,maze ,r+1 ,c);
        }
        if(c < maze.length-1){
           pathrestriction(p+'r' ,maze , r ,c+1);
        }
    }
}
