package Heap.heapsort;

import java.util.Arrays;

public class hSort {

    public static void heapSort(int[]arr , int n){
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, n, i);
        }
        int size = n;

        while(size > 1){
            swap(arr,1,size);
            size--;
            heapify(arr,size,1);
        }
    }

    public static void heapify(int[]arr,int n , int i){
        int largest = i;
        int left = 2*i;
        int right = left +1;

        if(left<=n && arr[left]>arr[largest]) largest = left;
        if(right<=n && arr[right]>arr[largest]) largest = right;

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
        heapSort(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
