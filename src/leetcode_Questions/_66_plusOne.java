package leetcode_Questions;

import java.util.Arrays;

public class _66_plusOne {
    public static void main(String[] args){
    int[] arr = {4,5,7,8,3,6};
    int[]val = plusOne(arr);
     System.out.println(Arrays.toString(val));

    }


    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                System.out.println(digits[i]);
                digits[i]++;
                System.out.println(digits[i]);
                return digits;
            }
            digits[i] = 0;
        }

        int[] arr = new int[digits.length + 1];
        for (int j = 1; j < arr.length; j++) {
            arr[j] = digits[j - 1];
        }
        arr[0] = 1;
        return arr;
    }
}

