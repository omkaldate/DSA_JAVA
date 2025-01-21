package matrix;

import java.util.Arrays;
import java.util.HashMap;

public class FirstCompletelyPaintedRoworColumn {
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        HashMap<Integer,int[]> map = new HashMap<>();

        for(int i=0; i<r; i++){
            for (int j =0; j<c; j++){
                int[]tuple = {i,j};
                map.put(mat[i][j], tuple);
            }
        }

        int[]row = new int[r];
        int[]col = new int[c];
        Arrays.fill(row,c);
        Arrays.fill(col,r);

        for(int x=0; x<arr.length; x++){
            int[]tup = map.get(arr[x]);
            int xx = tup[0];
            int yy = tup[1];

            col[yy] -=1;
            if(col[yy] == 0) return x;
            row[xx] -=1;
            if(row[xx] == 0) return x;
        }

        return -1;
    }


    public static void main(String[] args) {

    }
}
