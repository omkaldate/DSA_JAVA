package leetCodeContest.Weekly415;
import java.util.HashMap;
import java.util.Map;

public class TheTwoSneakyNumbersofDigitville {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> mpp =  new HashMap<>();

        for(int i=0; i<n; i++){
            mpp.put(nums[i] , mpp.getOrDefault(nums[i] , 0) +1);
        }

        int[]ans = new int[2];
        int a=0;

        for(Map.Entry<Integer,Integer> x : mpp.entrySet()){
            if(x.getValue() == 2){
                ans[a++] = x.getKey();
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
