package RECURSION_REVISION;

import java.util.Arrays;

public class MeargeSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 43, 68, 53};
        System.out.println(Arrays.toString(merge(arr)));
    }

    public static int[] merge(int[] arr) {
        if(arr.length == 1) return arr;
        int mid = arr.length / 2;

        int[] left = merge(Arrays.copyOfRange(arr, 0, mid));
        int[] right = merge(Arrays.copyOfRange(arr, mid, arr.length));

        return sort(left, right);
    }

    public static int[] sort(int[] left, int[] right) {
        int[] ans = new int[left.length + right.length];
        int l=0;
        int r=0;
        int k=0;

        while(l < left.length && r < right.length){
            if(left[l] < right[r]){
                ans[k++] = left[l++];
            }
            else ans[k++] = right[r++];
        }

        while(l < left.length){
            ans[k++] = left[l++];
        }
        while(r < right.length){
            ans[k++] = right[r++];
        }

        return ans;
    }
}