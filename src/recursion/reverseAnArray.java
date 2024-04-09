package recursion;

import java.util.Arrays;

public class reverseAnArray {
    public static void main(String[] args){
        int[]arr = {2,4,5,6,7};
        reverse(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void reverse(int[]arr , int l ,  int r){
        if( l > r){
            return;
        }
        swap(arr,l,r);
        reverse(arr,l+1,r-1);
    }


    static void swap(int[]arr , int l , int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
