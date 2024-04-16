package recursion;

import java.util.ArrayList;
import java.util.List;

public class permutationsInteger {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        permu(0 ,nums,ans);
        System.out.println(ans);

    }

    private static void permu(int ind , int[]arr, List<List<Integer>>ans){
        if(ind == arr.length){
            List<Integer>ds = new ArrayList<>();
            for(int i=0;i<arr.length; i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<arr.length; i++){
            swap(arr,i,ind);
            permu(ind+1 , arr, ans);
            swap(arr,i,ind);

        }
    }

    private static void swap(int[]arr , int a , int b){
        int temp =arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
