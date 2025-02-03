package RECURSION_REVISION;

import java.util.ArrayList;

public class mazeWithObstacle {
    public static void main(String[] args) {
        boolean[][] mat = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        System.out.print(fun(mat,"",mat.length-1,mat[0].length-1));
    }

    public static ArrayList<String> fun(boolean[][]mat, String str, int up, int left) {
        ArrayList<String> list = new ArrayList<>();

        if(up == 0 && left == 0){
            list.add(str);
            return list;
        }
        if(up >0 && mat[up-1][left] == true) {
            list.addAll(fun(mat,str + "u", up - 1, left));
        }
        if(left >0 && mat[up][left-1] == true){
            list.addAll(fun(mat,str+"l", up,left-1));
        }
        return list;
    }
}
