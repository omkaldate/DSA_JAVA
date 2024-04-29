package bitMasking;

public class MinimumNumberofOperationstoMakeArrayXOREqualtoK{
    public static void main(String[] args){
        int[]arr ={4,8,2,9};
        System.out.println(minOperations(arr , 3));
    }
    public static int minOperations(int[] nums, int k) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum ^= nums[i];
        }
        int val = sum ^ k;
        return Integer.bitCount(val);
    }
}
