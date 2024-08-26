package Heap;

import java.util.Arrays;

public class MergetwobinaryMaxheaps {
    public static void heapify(int[]arr , int i, int n){
        int large = i;
        int left = i*2+1;
        int right = i*2+2;

        if(left < n && arr[left] > arr[large]) large = left;
        if(right < n && arr[right] > arr[large]) large = right;

        if(i != large){
            swap(arr,i,large);
            heapify(arr,large,n);
        }
    }


    public static void swap(int[]arr , int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int []ans = new int[n+m];
        int x = 0;

        for(int i : a) ans[x++] = i;
        for(int s : b) ans[x++] = s;


        for(int i = ans.length/2; i>=0; i--){
            heapify(ans,i,ans.length);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {7,8,9};
        int []arr2 = {3,4,5};
        System.out.println(Arrays.toString(mergeHeaps(arr,arr2,arr.length,arr2.length)));
    }
}
