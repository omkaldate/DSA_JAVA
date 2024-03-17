package sortingAlgorithms;

import java.util.Arrays;
public class BS_in_2d_sorted {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(search(arr, 1)));
    }

    static int[] search(int[][] arr, int target) {
        int start = 0;
        int row = arr.length;
        int colum= arr[start].length;
        int end = (colum*row)-1;

        while(start <= end){
            int mid = start +(end-start)/2;
            int r = mid/colum;
            int c = mid%colum;
           // System.out.println(r);
            //System.out.println(c);
            if(arr[r][c] == target){
                return new int[]{r,c};
            }
            else if(arr[r][c] < target){
                start = mid+1;
            }
           else{
                end = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
