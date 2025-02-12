package hashMap;

import java.util.HashMap;

public class MaxSumofaPairWithEqualSumofDigits {
    public static int digit(int num){
        int sum =0;

        while(num %10 != num){
            int rem = num %10;
            sum += rem;
            num /= 10;
        }
        sum += num;
        return sum;
    }


    public static int maximumSum(int[] nums) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int ans = 0;
        int vis = 0;

        for(int i=0; i<nums.length; i++){
            int digitSum = digit(nums[i]);
            if(mpp.containsKey(digitSum)){
                ans = Math.max(ans, mpp.get(digitSum)+nums[i]);
                mpp.put(digitSum, Math.max(nums[i], mpp.get(digitSum)));
                vis = 1;
            }
            else{
                mpp.put(digitSum,nums[i]);
            }
        }

        return (vis == 1) ? ans : -1;
    }


    public static void main(String[] args) {

    }
}
