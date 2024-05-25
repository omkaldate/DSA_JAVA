package leetCodeContest.Biweekly131;

import java.util.HashMap;
import java.util.Map;

public class FindtheXORofNumbersWhichAppearTwice {
    public static int duplicateNumbersXOR(int[] nums) {
        int n= nums.length;
        int result =0;
        HashMap<Integer , Integer> mpp = new HashMap<>();

        for(int i=0; i<n; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0)+1);
        }

        boolean isTrue = false;
        for(Map.Entry<Integer,Integer> i : mpp.entrySet()){
            if(i.getValue() >= 2){
                result ^= i.getKey();
                isTrue = true;
            }
        }

        if(isTrue == true){
            return result;
        }
        return 0;
    }

    public static void main(String[] args){
        int []nums = {1,2,1,3};
        System.out.println(duplicateNumbersXOR(nums));
    }
}
