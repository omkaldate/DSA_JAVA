package RECURSION_REVISION;

import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int[]arr = {6,53,2,64,3,5,7,3};
        fun(arr,arr.length-1,0,0);
        System.out.println(Arrays.toString(arr));
    }

    public static void fun(int[]arr , int row, int col, int ind){
        if(row == 0) return;

        if(col <= row){
            if(arr[col] > arr[ind]){
                fun(arr,row,col+1,col);
            }
            else fun(arr,row,col+1,ind);

        }
        else{
            swap(arr,row,ind);
            fun(arr,row-1,0,0);
        }
    }

    public static void swap(int[]arr , int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
