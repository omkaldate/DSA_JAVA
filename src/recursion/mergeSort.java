package recursion;

import java.sql.SQLOutput;
import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args){
        int[]arr = {8,3,4,12,5,6};
        int[]ans = merge(arr);
        System.out.println(Arrays.toString(ans));

//        mergeInplace(arr ,0 , arr.length);
//        System.out.println(Arrays.toString(arr));
    }

    static int[] merge(int[]arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[]left = merge(Arrays.copyOfRange(arr,0,mid));
        int[]right = merge(Arrays.copyOfRange(arr,mid,arr.length));
        return sort(left,right);
    }

      private static int[] sort(int[]arr1,int[]arr2){
        int[]mix = new int[arr1.length + arr2.length];
        int i=0,j=0,k=0;
        while(i< arr1.length && j< arr2.length){
            if(arr1[i] < arr2[j]){
                mix[k] = arr1[i];
                i++;
            }
            else{
                mix[k] = arr2[j];
                j++;
            }
            k++;

        }
        while(i < arr1.length){
            mix[k] = arr1[i];
            i++;
            k++;
        }
        while(j < arr2.length){
            mix[k] = arr2[j];
            j++;
            k++;
        }
        return mix;
    }

//    static void mergeInplace(int[]arr , int s , int e){
//        if(e - s == 1){
//            return;
//        }
//        int mid = s+(e-s)/2;
//        mergeInplace(arr,s,mid);
//        mergeInplace(arr,mid,e);
//         sortInplace(arr , s , mid , e);
//    }
//
//    private static void sortInplace(int[]arr,int s , int m , int e){
//        int[]mix = new int[e-s];
//        int i=s,j=m,k=0;
//        while(i< m && j< e){
//            if(arr[i] < arr[j]){
//                mix[k] = arr[i];
//                i++;
//            }
//            else{
//                mix[k] = arr[j];
//                j++;
//            }
//            k++;
//
//        }
//        while(i < m){
//            mix[k] = arr[i];
//            i++;
//            k++;
//        }
//        while(j < e){
//            mix[k] = arr[j];
//            j++;
//            k++;
//        }
//        for(int x=0; x<mix.length; x++){
//            arr[s+x] = mix[x];
//        }
//    }
}
