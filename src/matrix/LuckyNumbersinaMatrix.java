package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbersinaMatrix {

    public static int rowmin(int[]arr){
        int max = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < max) max = arr[i];
        }
        return max;
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[]col = new int[c];
        int[]row = new int[r];

        for(int i=0; i<r; i++){
            row[i] = rowmin(matrix[i]);
        }


        for(int i=0; i<c; i++){
            int min = Integer.MIN_VALUE;
            for(int j =0;j<r; j++){
                if(matrix[j][i] > min) min = matrix[j][i];
            }
            col[i] = min;
        }

     //   System.out.println(Arrays.toString(row));
     //   System.out.println(Arrays.toString(col));
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(row[i] == col[j])list.add(row[i]);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[][]matrix = {
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };
        System.out.println(luckyNumbers(matrix));
    }
}
