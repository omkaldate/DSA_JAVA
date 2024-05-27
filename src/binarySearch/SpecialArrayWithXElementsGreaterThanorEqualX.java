package binarySearch;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanorEqualX {
    public static int isSpecial(int[] arr , int x){
        int s = 0;
        for(int e : arr){
            if(e >= x)s++;
        }
        if(s == x){
            return 0;
        }
        return 1;
    }

    public static int specialArray(int[] nums) {
        int maxi =0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(maxi < nums[i]){
                maxi = nums[i];
            }
        }
        for(int i=0; i<= maxi ;i++ ){
            int ans = isSpecial(nums , i);
            if(ans == 0){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        int[] arr = {0,4,3,0,4};
        System.out.println(specialArray(arr));
    }

}
