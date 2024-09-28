package leetCodeContest.Biweekly140;

public class MinimumElementAfterReplacementWithDigitSum {
    public static int funk(int num){
        int ans =0;

        while(num%10 != num){
            ans += num%10;
            num  /= 10;
        }
        return ans+num;
    }

    public static int minElement(int[] nums) {
        int ans =Integer.MAX_VALUE;

        for(int i: nums){
            ans = Math.min(ans,funk(i));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
