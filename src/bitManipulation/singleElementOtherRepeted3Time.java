package bitManipulation;

public class singleElementOtherRepeted3Time {
    public static void main(String[] args){
        int[] nums={2,2,3,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int[]arr = new int[32];

        for(int i=0;i<n;i++){
            for(int j=0; j<32; j++){
                if((nums[i]&1<<j) !=0){
                    arr[j] += 1;
                }
            }
        }
        long ans=0;
        for(int i=0;i<32;i++){
            ans +=(long) (arr[i] %3) * Math.pow(2 , i);
        }

        return (int)ans;
    }
}
