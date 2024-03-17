package binarySearch_4_hoursProblems;

import java.util.Arrays;

public class _2dArr_sortedRandC_target {
    public static void main(String[] args){
        int[][]arr = {
                {10,20,31,39},
                {12,23,32,40},
                {15,27,33,50},
                {19,30,38,66}
        };

        System.out.println(Arrays.toString(index(arr , 50)));

    }

    public static int[] index(int[][]arr , int target){
        int row =0;
        int col = arr[0].length-1;

        while(row < arr.length  &&  col >= 0){
            if(arr[row][col] == target){
                return new int[]{row,col};
            }
            if(target > arr[row][col]){
                row++;
            }
            else{
                col--;
            }
        }
        return new int[]{-1 , -1};
    }
}
