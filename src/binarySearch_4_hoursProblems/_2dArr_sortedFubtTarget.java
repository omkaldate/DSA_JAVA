package binarySearch_4_hoursProblems;

import java.util.Arrays;

public class _2dArr_sortedFubtTarget {
    public static void main(String[] args){
        int[][]arr = {
                {10,20,31,39},
                {40,41,42,49},
                {50,55,57,59},
                {60,61,62,66}
        };

        System.out.println(Arrays.toString(index(arr , 42)));

    }

  public static int[] index(int[][]arr , int target){
        int row = arr.length;
        int col = arr[0].length;
        int end = arr.length * arr[0].length-1;
        int start = 0;

        while(start <= end){
            int m = start+(end-start)/2;
            int r=m/col;
            int c=m%col;
            if(arr[r][c] == target){
                return new int[]{r,c};
            }
            if(arr[r][c] < target){
                start = m+1;
            }
            else{
                end = m-1;
            }
        }
        return new int[]{-1,-1};
    }


    }



