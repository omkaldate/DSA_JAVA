package Heap;

import java.util.Arrays;

public class HeapifyAlgo {

   public static void heapify(int[]arr,int n , int i){
        int largest = i;
        int left = 2*i;
        int right = left +1;

        if(left<=n && arr[left]>arr[largest]) largest = left;   // changed <= instead of <
        if(right<=n && arr[right]>arr[largest]) largest = right;    // same as above <=

        if(largest != i){
            swap(arr,largest,i);
            heapify(arr,n,largest);
        }
    }


    public static void swap(int[]arr, int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[]arr = {-1,54,53,55,52,50};
        int n = arr.length-1;
        for(int i=n/2; i>0; i--) {
            heapify(arr, n, i);
        }

        System.out.println(Arrays.toString(arr));
    }
}
