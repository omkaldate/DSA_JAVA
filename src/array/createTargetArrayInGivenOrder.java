package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class createTargetArrayInGivenOrder {
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> arr = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            arr.add(index[i], nums[i]);
        }

        int[] target = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            target[i] = arr.get(i);
        }

        return target;
    }

    public static void main(String[] args){
        int []nums = {0,1,2,3,4};
        int[]index = {0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(nums , index)));
    }
}
