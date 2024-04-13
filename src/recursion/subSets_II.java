package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSets_II {
    public static void main(String[] args){
        int[]nums = {1,2,2,2,3,3};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subset(0,nums,new ArrayList<Integer>() ,ans);
       System.out.println(ans);

        // couninue means skip that further code & jump on direct loop for next i value
        for(int i=0; i<5;i++){
            if(i==3)continue;
            System.out.println(i);
        }
    }

    public static void subset(int ind , int[]nums , List<Integer>ds , List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i=ind ; i<nums.length; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            subset(i+1 , nums , ds , ans);
            ds.remove(ds.size()-1);
        }
    }
}
