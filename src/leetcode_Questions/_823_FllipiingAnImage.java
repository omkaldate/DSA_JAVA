package leetcode_Questions;

import java.util.Arrays;

public class _823_FllipiingAnImage {
    public static void main(String[] args){
        int[][] arr ={
                {1,0,0,1},
                {0,0,1,0},
                {1,1,1,1}
        };

       int[][]ans = flipAndInvertImage(arr);
       for(int i=0; i<ans.length; i++){
           for(int j=0; j<ans[i].length; j++){
               System.out.print(ans[i][j] + " ");
           }
           System.out.println();
       }
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for(int[] row : image){
            for(int i=0; i< (n+1)/2; i++){
                int temp = row[i]^1;
                row[i] = row[n-1-i]^1;
                row[n-1-i] = temp;
            }
        }
        return image;
    }
}

