package RECURSION_REVISION;

import java.util.ArrayList;

public class mazeWithAllpath {
    public static void main(String[] args) {
        int[][]mat = new int[3][3];
        System.out.println(fun("",mat,0,0));
    }

    public static ArrayList<String> fun(String str, int[][]mat, int row, int col){
        ArrayList<String> list = new ArrayList<>();

        if(row== mat.length-1 && col == mat[0].length-1){
            list.add(str);
            return list;
        }

        if(mat[row][col] == 0) {
            if (row > 0) {
                mat[row][col] = 1;
                list.addAll(fun(str + "U", mat, row - 1, col));
            }

            if (row < mat.length - 1) {
                mat[row][col] = 1;
                list.addAll(fun(str + "D", mat, row + 1, col));
            }
            if (col > 0) {
                mat[row][col] = 1;
                list.addAll(fun(str + "L", mat, row, col - 1));
            }
            if (col < mat[0].length - 1) {
                mat[row][col] = 1;
                list.addAll(fun(str + "R", mat, row, col + 1));
            }
        }
        else {
            return list;
        }
        mat[row][col] = 0;

        return list;
    }
}
