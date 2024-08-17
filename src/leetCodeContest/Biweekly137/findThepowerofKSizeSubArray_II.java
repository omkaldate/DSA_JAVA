package leetCodeContest.Biweekly137;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findThepowerofKSizeSubArray_II {
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        int l =0;
        int r =0;
        boolean isTrue = false;
        int prev = nums[0];

        while(r < n){

            if(r-l+1 == k){
                if(isTrue && nums[r]== prev+1){
                    list.add(nums[r]);
                    l++;
                    prev = nums[r];
                }
                else{
                    boolean x = true;
                    for(int i=l; i<r; i++){
                        if(nums[i]+1 != nums[i+1]){
                            x = false;
                            break;
                        }
                    }
                    if(x == false){
                        list.add(-1);
                        isTrue = false;
                        l++;
                    }
                    else{
                        isTrue = true;
                        prev = nums[r];
                        list.add(nums[r]);
                        l++;
                    }

                }
            }

            r++;
        }


        int[]ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[]arr = {1,2,3,4,3,2,5};
        int k = 3;
        System.out.println(Arrays.toString(resultsArray(arr , k)));
    }
}
