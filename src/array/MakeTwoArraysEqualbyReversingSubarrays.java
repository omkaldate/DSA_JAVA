package array;

import java.util.Arrays;

public class MakeTwoArraysEqualbyReversingSubarrays {
    
    public static boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        Arrays.sort(target);
        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            if(target[i] != arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        int []arr = {2,5,3,1,6,7};
        int []arr1 = {5,3,2,1,7,6};
        System.out.println(canBeEqual(arr , arr1));
    }
}
