package leetcode_Questions;

import java.util.Arrays;

public class _118_pasclesTriangle {
    public static void main(String  rgs[]){

        int RowNums =5;


        int n = RowNums;

        int[][]arr = new int[n][n];
        arr[0][0] =1;
        for(int i=1; i<n ; i++){
            arr[i][0] =1;
            for(int j=1 ; j<i; j++){
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
            arr[i][i] =1;

        }
        for(int[] x : arr) {
            System.out.println(Arrays.toString(x));
        }
    }
}
