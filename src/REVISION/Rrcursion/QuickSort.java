package REVISION.Rrcursion;

import java.util.Arrays;

public class QuickSort {

    public static void quick(int[]arr,int low,int high){
        if(low > high)return;

        int pivot = partition(arr,low,high);
        quick(arr,low,pivot-1);
        quick(arr,pivot+1,high);
    }

    public static int partition(int[] arr,int low , int high){
        int i=low;
        int j=high;
        int pvt=arr[low];

        while(i<j){
            while(arr[i] <= pvt){
                i++;
            }
            while(arr[j] > pvt){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]=temp;
            }
        }
         int temp = arr[j];
        arr[j] = arr[low];
        arr[low]=temp;

        return j;
    }




    public static void main(String[] args) {
        int[]arr = {7,4,5,7,3,2,9};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
