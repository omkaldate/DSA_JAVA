package practiceJuspay;

import java.util.Arrays;

public class quickSort {

    public static void sort(int[]arr, int s, int e){
        if(s >= e) return;

        int pivot = findPivot(arr,s,e);
        sort(arr, s, pivot-1);
        sort(arr, pivot+1, e);
    }

    public static int findPivot(int[]arr, int s, int e){
            int pivot = s;

            for(int i=s; i<=e; i++){
                if(arr[i] < arr[s]) pivot++;
            }
            swap(arr, pivot, s);

            while(s < pivot && e > pivot){
                while(arr[s] < arr[pivot]) s++;
                while(arr[e] > arr[pivot]) e--;
                //if(s < pivot && e > pivot) {
                    swap(arr, s++, e--);
               // }
            }

            return pivot;
    }

    public static void swap(int[]arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int[] arr = {2, 3, 4, 5, 1};

        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
