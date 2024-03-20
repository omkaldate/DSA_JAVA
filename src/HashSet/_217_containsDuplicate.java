package HashSet;

import java.util.HashSet;

public class _217_containsDuplicate {
public static void main(String[] args){
    int[]arr = {8,9,0,89,67,7};
    System.out.println(containsDuplicate(arr));
}


    public static boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> frequency = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(frequency.contains(nums[i]))
                return true;
            else
                frequency.add(nums[i]);
        }
        return false;
    }
}
