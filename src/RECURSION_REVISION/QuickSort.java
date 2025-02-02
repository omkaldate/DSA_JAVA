package RECURSION_REVISION;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[]arr = {9,6,5,4,32,2,22,344,3,55};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick (int[]arr,int s, int e){
        if(s>=e) return ;
        int pivot = partition(arr,s,e);
        quick(arr,s,pivot-1);
        quick(arr,pivot+1,e);
    }

    public static int partition(int[]arr, int s , int e){
        int cnt =0;
        for(int i=s+1; i<=e; i++) if(arr[i] < arr[s]) cnt++;
        int pivot = cnt +s;

        swap(arr,s,pivot);

        int i = s;
        int j= e;

        while(i<j){
            while( i<j && arr[i] < arr[pivot]) i++;
            while(i<j && arr[j] > arr[pivot]) j--;
            swap(arr,i,j);
            i++;
            j--;
        }
        return pivot;
    }


    public static void swap(int[]arr , int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
