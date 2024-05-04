package array;

import java.util.ArrayList;
import java.util.Arrays;

public class NextGreaterElement_I {
    public static int binary(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayList<Integer> ls = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            int ind = binary(nums2, nums1[i]);
            boolean isdone = false;

            for (int x = ind; x < nums2.length; x++) {
                if (nums2[ind] < nums2[x]) {
                    ls.add(nums2[x]);
                    isdone = true;
                    break;
                }
            }
            if (!isdone) {
                ls.add(-1);
            }
        }

        int[] arr = new int[ls.size()];
        for (int j = 0; j < ls.size(); j++) {
            arr[j] = ls.get(j);
        }
        return arr;
    }


    public static void main(String[] args){
        int[] nums1 = {2,1,3};
        int[] nums2 = {2,3,1};
        System.out.println(Arrays.toString(nextGreaterElement(nums1 , nums2)));
    }
}
