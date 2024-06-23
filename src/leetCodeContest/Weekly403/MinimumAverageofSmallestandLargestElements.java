package leetCodeContest.Weekly403;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumAverageofSmallestandLargestElements {
    public static double minimumAverage(int[] nums) {
        int n = nums.length;

        HashSet<Float> stt = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<n/2; i++){
            stt.add((float) (nums[i]+nums[n-i-1])/2);

        }

        float max = Float.MAX_VALUE;

        for(float avg : stt){
            if(avg < max){
                max = avg;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int []arr = {7,8,3,4,15,13,4,1};
        System.out.println(minimumAverage(arr));
    }
}
