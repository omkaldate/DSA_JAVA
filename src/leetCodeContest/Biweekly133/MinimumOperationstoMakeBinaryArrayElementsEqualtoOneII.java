package leetCodeContest.Biweekly133;

public record MinimumOperationstoMakeBinaryArrayElementsEqualtoOneII() {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int convert =0;
        int mini = 0;

        for(int i=0; i<n; i++){
            if(convert%2 == 0){
                if(nums[i] == 0){
                    nums[i]=1;
                    mini ++;
                    convert++;
                }
            }
            else{
                nums[i] = 1-nums[i];
                if(nums[i] == 0){
                    nums[i] =1;
                    mini++;
                    convert++;
                }
            }
        }
        for(int j=0; j<n; j++){
            if(nums[j] == 0)return -1;
        }
        return mini;

    }


    public static void main(String[] args){
        int []arr = {0,1,1,0,1};
        System.out.println(minOperations(arr));
    }
}
