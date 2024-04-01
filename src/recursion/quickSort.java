package recursion;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args){
        int[]arr = {3,1,4,5,2};
        quickS(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickS(int[]arr , int s , int e){
        if(s > e){
            return;
        }
        int p = partition(arr , s , e);
        quickS(arr,s,p-1);
        quickS(arr,p+1,e);
    }

    public static int partition(int[]arr ,int s , int e){
        int pivot = arr[s];
        int cnt = 0;

        for(int i=s+1; i<= e; i++){
            if(arr[i] < pivot){
                cnt++;
            }
        }
        int pivotIndex = s+cnt;
        swap( arr ,s , pivotIndex);
        int i= s;
        int j= e;
        while(i< pivotIndex && j> pivotIndex){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i< pivotIndex && j> pivotIndex){
                swap(arr , i , j);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    public static void swap(int[]arr , int n1,int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
