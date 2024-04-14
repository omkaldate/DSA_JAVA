package leetCodeContest.Weeklycontest393;
//You are given an integer array nums.
//Return an integer that is the maximum distance between the indices of two (not necessarily different) prime numbers in nums.
//Example 1:
//Input: nums = [4,2,9,5,3]
//Output: 3
//Explanation: nums[1], nums[3], and nums[4] are prime. So the answer is |4 - 1| = 3.

public class maximunPrimeDifference {
    public static void main(String[] args){
        int[]nums = {4,2,9,5,3};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            boolean ans = isPrime(nums[i]);
            if(ans){
                if(i<= min){
                    min =i;
                }
                if(i >= max)
                    max = i;
            }
        }
        System.out.println(max-min);
    }

    public static boolean isPrime(int n){
        if(n<= 1){
            return false;
        }
        for(int i=2; i<=n/2; i++){
            if(n%i ==0){
                return false;
            }
        }
        return true;
    }
}
