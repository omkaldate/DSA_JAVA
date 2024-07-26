package matrix;

import java.util.Arrays;

public class findValidMatrixgivenRowNadColumn {

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowLen=rowSum.length;
        int colLen=colSum.length;

        int r=0;
        int c=0;

        int[][] mat=new int[rowLen][colLen];
        while(r<rowLen && c<colLen){
            if(rowSum[r]<colSum[c]){
                mat[r][c]=rowSum[r];
                colSum[c]=colSum[c]-rowSum[r];
                r++;
            }
            else{
                mat[r][c]=colSum[c];
                rowSum[r]=rowSum[r]-colSum[c];
                c++;
            }
        }
        return mat;
    }



    public static void main(String[] args) {
        int[]rowSum = {5,7,10};
        int[]colSum = {8,6,8};

        int[]arr= {1,3};

       int[][]ans = restoreMatrix(rowSum,colSum);
        for(int[]x : ans){
            System.out.println(Arrays.toString(x));
        }
    }
}
