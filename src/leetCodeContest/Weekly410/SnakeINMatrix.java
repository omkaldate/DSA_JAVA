package leetCodeContest.Weekly410;

import java.util.ArrayList;
import java.util.List;

public class SnakeINMatrix {
    public static int finalPositionOfSnake(int n, List<String> commands) {

        int[][]grid = new int[n][n];

        int row = 0;
        int col = 0;

        for(int i=0; i<commands.size(); i++){
            String s = commands.get(i);
            System.out.println(s);

            if(s.equals("UP") && row>0){
                row--;
            }
            if(s.equals("RIGHT") && col<n-1){
                col++;
            }
            if(s.equals("DOWN") && row<n-1){
                row++;
            }
            if(s.equals("LEFT") && col>0){
                col--;
            }
        }
        System.out.println(row + " " + col);
        return (row*n)+col;
    }



    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("RIGHT");
        s.add("UP");
        System.out.println(finalPositionOfSnake(3,s));

    }
}
