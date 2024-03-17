package leetcode_Questions;
import java.util.HashMap;
import java.util.HashSet;

public class _349_InsertionOfTwoArrays {
    public static void main(String[] args){
        int[] nums1={2,4,6,8,9,43,23};
        int[] nums2 = {3,4,67,45,2,45,57,56};
        int []ans = intersection(nums1 , nums2);
        for(int i: ans){
            System.out.print(i + " ");
        }
    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n1 = nums2.length;
        HashSet<Integer> stt = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            stt.add(nums1[i]);
        }
        for (int j = 0; j < n1; j++) {
            if (stt.contains(nums2[j])) {
                s2.add(nums2[j]);
            }
        }
        int a = 0;
        int[] arr = new int[s2.size()];
        for (int i : s2) {
            arr[a++] = i;
        }
        return arr;
    }
}
