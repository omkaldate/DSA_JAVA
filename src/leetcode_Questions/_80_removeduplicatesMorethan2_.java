package leetcode_Questions;
import java.util.Arrays;
public class _80_removeduplicatesMorethan2_ {

    public static void main(String[] args){

        int nums[] ={1,1,2,3,3,3,3,4,4,5};
        int ans = removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(ans);

    }

    public static int removeDuplicates(int[] nums) {
        int n=nums.length;

        int j = 1;
        for (int i = 1; i < n; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;

    }
}
