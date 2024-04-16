package recursion;

import java.util.ArrayList;
import java.util.List;

public class permutationsIntegerusingDS {
    public static void main(String[] args){
        int[]nums = {1,2,3};
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>ds = new ArrayList<>();
        boolean []freq = new boolean[nums.length];
        funk(nums,ds,ans,freq);
        System.out.println(ans);
    }


    public static void funk(int[]nums , List<Integer> ds , List<List<Integer>>ans ,boolean[]freq){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(! freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                funk(nums,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}
