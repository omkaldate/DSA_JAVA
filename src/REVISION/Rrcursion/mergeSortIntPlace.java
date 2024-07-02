package REVISION.Rrcursion;

import java.util.Arrays;

public class mergeSortIntPlace {

    public static void merge(int[]arr,int s,int e){
        if(s >= e)return;

        int m = s+(e-s)/2;
        merge(arr,s,m);
        merge(arr,m+1,e);
        sort(arr,s,m,e);
    }
    public static void sort(int[]arr , int s,int m,int e){
        int[]arr2 = new int[e-s + 1];
        int i=s;
        int j=m+1;
        int k=0;

        while(i<=m && j<=e){
            if(arr[i] < arr[j]){
                arr2[k++] = arr[i++];
            }
            else{
                arr2[k++] = arr[j++];
            }
        }
        while(i<=m){
            arr2[k++] = arr[i++];
        }
        while(j<=e){
            arr2[k++] = arr[j++];
        }

        for(int x=0; x<arr2.length; x++){
            arr[s+x] = arr2[x];
        }
    }




    public static void main(String[] args) {
        int[]arr = {6,5,4,3,2,1};
        merge(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
