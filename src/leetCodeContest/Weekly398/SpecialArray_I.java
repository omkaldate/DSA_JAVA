package leetCodeContest.Weekly398;

public class SpecialArray_I {
    public static boolean isArraySpecial(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
        {
            if((nums[i]%2==0 && nums[i+1]%2==0) || (nums[i]%2==1 && nums[i+1]%2==1))
            {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        int[] arr = {1,1,6,9};
        System.out.println(isArraySpecial(arr));
    }
}
