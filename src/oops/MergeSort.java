package oops;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[]arr){
        if(arr.length == 1) return arr;

        int m = arr.length/2;
        int[] left = merge(Arrays.copyOfRange(arr,0, m));
        int[] right = merge(Arrays.copyOfRange(arr,m,arr.length));

        return sort(left, right);
    }

    private static int[] sort(int[] left, int[] right) {
        int l = left.length + right.length;
        int[]ans = new int[l];

        int i= 0;
        int j = 0;
        int x = 0;

        while( i< left.length && j < right.length){
            if(left[i] < right[j]){
                ans[x++] = left[i++];
            }
            else  ans[x++] = right[j++];
        }

        while(i < left.length){
            ans[x++] = left[i++];
        }

        while(i < left.length){
            ans[x++] = right[j++];
        }

        return ans;
    }


    public static void main(String[] args) {
        int[]arr = {9,8,7,6,5,4,3,2,1};

        System.out.println(Arrays.toString(merge(arr)));
    }
}
