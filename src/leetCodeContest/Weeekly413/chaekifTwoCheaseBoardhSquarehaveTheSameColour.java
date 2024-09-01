package leetCodeContest.Weeekly413;

import java.util.HashMap;

public class chaekifTwoCheaseBoardhSquarehaveTheSameColour {
    public static boolean checkTwoChessboards(String board1, String board2) {
        int[][]grid = {
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0},
                {0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0}
        };

        HashMap<Character,Integer> mpp = new HashMap<>();
        mpp.put('a',0);
        mpp.put('b',1);
        mpp.put('c',2);
        mpp.put('d',3);
        mpp.put('e',4);
        mpp.put('f',5);
        mpp.put('g',6);
        mpp.put('h',7);

        int x = Integer.valueOf(mpp.get(board1.charAt(0)));
        int y = Integer.valueOf(board1.charAt(1));

        int a = Integer.valueOf(mpp.get(board2.charAt(0)));
        int b = Integer.valueOf(board2.charAt(1));

        System.out.print(x+" "+y+" "+a+" "+b);
        int val = grid[x][y-1-48];
        int val2 = grid[a][b-1-48];

        if(val == val2) return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
