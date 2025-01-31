package RECURSION_REVISION;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[]arr = {5,4,3,2,1};
        fun(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void fun(int[]arr, int row, int col){
        if(row == 0) return;

        if(col < row){
            if(arr[col+1] < arr[col]){
                swap(arr, col, col+1);
            }
            fun(arr,row,col+1);
        }
        else{
            fun(arr,row-1,0);
        }
    }

    public static void swap(int[]arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
