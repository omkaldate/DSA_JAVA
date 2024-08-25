package leetCodeContest.Weekly412;

import java.util.Arrays;

public class FinalArrayStateAfterKMultiplivationOperatin_I {
    private static int min(int[]arr){
        int val = arr.length-1;

        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] <= arr[val]) val = i;
        }
        return val;
    }


    public static int[] getFinalState(int[] nums, int k, int multiplier) {

        for(int i=0; i<k; i++){
            int m = min(nums);
            System.out.println(m);
            nums[m] = nums[m]*multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[]arr = {2,1,3,5,6};
        System.out.println(Arrays.toString(getFinalState(arr,5,2)));
    }
}
