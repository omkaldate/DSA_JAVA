package recursion;

import java.util.ArrayList;

public class MaximumPossibleNumberbyBinaryConcatenation {
    public static int value(ArrayList<Integer> nums){
        String str ="";

        for(int i=0; i<nums.size(); i++){
            str += Integer.toBinaryString(nums.get(i));
        }
        return Integer.parseInt(str, 2);
    }


    private static void recurPermute(int index, int[] nums, ArrayList<ArrayList<Integer>> ans) {
        if (index == nums.length) {
            ArrayList<Integer> ds = new ArrayList< >();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }
    private static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static int maxGoodNumber(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        recurPermute(0,nums,list);

        int ans = Integer.MIN_VALUE;
        for(ArrayList<Integer> l: list){
            System.out.println(l);
            ans = Math.max(ans,value(l) );
        }
        return ans;
    }



    public static void main(String[] args) {

    }
}
