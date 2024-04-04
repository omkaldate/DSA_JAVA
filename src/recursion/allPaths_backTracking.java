package recursion;

public class allPaths_backTracking {
    public static void main(String[] args){
        boolean [][]board = {
                {true ,true, true},
                {true ,true, true},
                {true ,true, true}

        };
       // allpath("" ,board ,0 ,0);
        backTrack("",board ,0,0);
    }

//    static void allpath(String p ,boolean [][]maze, int r , int c){
//        if(r== maze.length-1 && c==maze[0].length-1){
//            System.out.println(p);
//            return;
//        }
//        if(!maze[r][c]){
//            return;
//        }
//        if(r < maze.length-1){
//            allpath(p+'d' ,maze ,r+1 ,c);
//        }
//        if(c < maze.length-1){
//            allpath(p+'r' ,maze , r ,c+1);
//        }
//        if(r > 0){
//            allpath(p+'u' ,maze , r-1 ,c);
//        }
//        if(c > 0){
//            allpath(p+'l' ,maze , r ,c-1);
//        }
//    }

    static void backTrack(String p ,boolean [][]maze, int r , int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        if(r < maze.length-1){
            backTrack(p+'d' ,maze ,r+1 ,c);
        }
        if(c < maze.length-1){
            backTrack(p+'r' ,maze , r ,c+1);
        }
        if(r > 0){
            backTrack(p+'u' ,maze , r-1 ,c);
        }
        if(c > 0){
            backTrack(p+'l' ,maze , r ,c-1);
        }
        // This line is where the function will be over
        //so before the function gets removed , also remove the changes that were made by that function
        maze[r][c] = true;
    }
}
