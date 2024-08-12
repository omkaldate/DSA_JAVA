package basicPrograms;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] arr) {
        if (arr.length == 1)   return arr;
        
        int mid = arr.length / 2;
        int[] left = merge(Arrays.copyOfRange(arr, 0, mid));
        int[] right = merge(Arrays.copyOfRange(arr, mid, arr.length));
        return sort(left, right);
    }

    private static int[] sort(int[] arr1, int[] arr2) {
        int[] mix = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mix[k] = arr1[i];
                i++;
            } else {
                mix[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            mix[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            mix[k] = arr2[j];
            j++;
            k++;
        }
        return mix;
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 4, 2, 7, 6, 1};
        arr = merge(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
