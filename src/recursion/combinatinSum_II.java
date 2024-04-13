package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinatinSum_II {
    public static void main(String[] args){
        int[] candidates = {1,1,1,2,2};
        int target = 4;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combi(0,candidates,target,ans,new ArrayList<>());
        System.out.println(ans);
    }

   private static void combi(int ind,int[]arr,int target,List<List<Integer>> ans , List<Integer>ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i< arr.length; i++){
            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            combi(i+1,arr,target-arr[i] , ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}
