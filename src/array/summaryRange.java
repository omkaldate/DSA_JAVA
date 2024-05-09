package array;

import java.util.ArrayList;
import java.util.List;

public class summaryRange {
    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;

        List<String>ls = new ArrayList<>();

        for(int i=0; i<n; i++){
            int start = i;
            while((i+1 < n) && nums[i]+1 == nums[i+1]){
                i++;
            }
            if(start != i){
                ls.add(Integer.toString(nums[start]) + "->" +  Integer.toString(nums[i]));
            }
            else{
                ls.add(Integer.toString(nums[i]));
            }
        }
        return ls;
    }

    public static void main(String[] args){
        int[]arr = {0,1,2,4,5,7};
        System.out.println(summaryRanges(arr));
    }
}
