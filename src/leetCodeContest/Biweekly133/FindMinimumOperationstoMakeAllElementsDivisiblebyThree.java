package leetCodeContest.Biweekly133;

public class FindMinimumOperationstoMakeAllElementsDivisiblebyThree {
    public static int minimumOperations(int[] nums) {
        int n = nums.length;
        int cnt =0;

        for(int i=0; i<n; i++){
            if(nums[i]%3 != 0) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args){
        int []arr = {3,5,6,9};
        System.out.println(minimumOperations(arr));
    }
}
