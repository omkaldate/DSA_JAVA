package leetCodeContest.Biweekly133;

public class MinimumOperationstoMakeBinaryArrayElementsEqualtoOneI {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int cnt =0;

        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                if(i+2 < n){
                        nums[i]= 1;
                        nums[i+1]=nums[i+1]^1;
                        nums[i+2]=nums[i+2]^1;
                        cnt++;
                }
                else{
                    return -1;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        int []arr = {0,1,1,1,0,0};
        System.out.println(minOperations(arr));
    }
}
