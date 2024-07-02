package REVISION.Rrcursion;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[]arr){
        if(arr.length == 1)return arr;

        int m = arr.length/2;
        int[]l = merge(Arrays.copyOfRange(arr,0,m));
        int[]r = merge(Arrays.copyOfRange(arr,m,arr.length));
        return sort(l,r);
    }


    private static int[] sort(int[]l , int[]r){
        int[] arr2 = new int[l.length + r.length];
        int i=0;
        int j=0;
        int k =0;
        while(i<l.length && j<r.length){
            if(l[i] < r[j]){
                arr2[k++] = l[i++];
            }
            else{
                arr2[k++] = r[j++];
            }
        }
        while(i<l.length){
            arr2[k++] = l[i++];
        }
        while(j<r.length){
            arr2[k++] = r[j++];
        }
        return arr2;
    }



    public static void main(String[] args) {
        int[]arr = {8,3,4,12,5,6};
        System.out.println(Arrays.toString(merge(arr)));
    }
}
