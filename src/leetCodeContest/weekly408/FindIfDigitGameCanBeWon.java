package leetCodeContest.weekly408;

public class FindIfDigitGameCanBeWon {
    public static boolean canAliceWin(int[] nums) {
        int single=0;
        int two =0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]%10 == nums[i]) single += nums[i];
            else two += nums[i];
        }
        if(single == two) return false;
        return true;
    }

    public static void main(String[] args) {
        int[]nums = {1,2,3,4,10};
        System.out.println(canAliceWin(nums));
    }
}
