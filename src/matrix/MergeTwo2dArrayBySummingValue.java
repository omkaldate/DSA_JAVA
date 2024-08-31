package matrix;

import java.util.Arrays;

public class MergeTwo2dArrayBySummingValue {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;

        int[] freqArray = new int[1001];

        for (int i = 0; i < size1; i++) {
            freqArray[nums1[i][0]] = nums1[i][1];
        }

        for (int i = 0; i < size2; i++) {
            freqArray[nums2[i][0]] += nums2[i][1];
        }

        int freqArray_size = 0;
        for (int i = 0; i < 1001; i++) {
            if (freqArray[i] != 0) {
                freqArray_size++;
            }
        }

        int resultArray[][] = new int[freqArray_size][2];

        for (int i = 0,j=0; i < 1001; i++) {
            if (freqArray[i] != 0) {
                resultArray[j][0] = i;
                resultArray[j][1] = freqArray[i];
                j++;
            }
        }
        return resultArray;
    }


    public static void main(String[] args) {
        int[][]arr1 = {{1,2},{2,3},{4,5}};
        int[][]arr2 = {{1,4},{3,2},{4,1}};

        int[][]arr = mergeArrays(arr1,arr2);

        for(int[] x : arr){
            System.out.println(Arrays.toString(x));
        }
    }
}
