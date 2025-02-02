package RECURSION_REVISION;

import java.util.Arrays;

public class mergeSortInplace {
    public static void main(String[] args) {
        int[] arr = {6, 5, 43, 68, 53};
        merge(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int s, int e) {
        if(s >= e) return;
        int mid = s+(e-s)/2;

        merge(arr, s, mid);
        merge(arr, mid+1, e);

        sort(arr, s, mid,e);
    }

    public static void sort(int[]arr, int s, int m, int e) {
        int[]ans = new int[e-s+1];
        int k = 0;
        int i =s;
        int j = m+1;

        while(i<=m && j<=e){
            if(arr[i] < arr[j]) ans[k++] = arr[i++];
            else ans[k++] = arr[j++];
        }

        while(i <= m) ans[k++] = arr[i++];
        while(j <= e) ans[k++] = arr[j++];

        k=0;
        for(int z=s; z<=e; z++){
            arr[z] =ans[k++];
        }
    }

}
