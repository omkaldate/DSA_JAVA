package leetCodeContest.Biweekly131;

import java.util.Arrays;
import java.util.HashMap;

public class FindOccurrencesofanElementinanArray {
    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        int n = nums.length;
        int n1 = queries.length;
        int occure =1;
        HashMap<Integer , Integer> mpp = new HashMap<>();
        int arr[] = new int[n1];
        int index=0;

        for(int i=0; i<n; i++){
            if(nums[i] == x){
                mpp.put(occure , i);
                occure++;
            }
        }

        for(int i=0; i<n1; i++){
            if(mpp.containsKey(queries[i])){
                arr[index] = mpp.get(queries[i]);
                index++;
            }
            else{
                arr[index] = -1;
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int []nums = {1,3,1,7};
        int []queries = {1,3,2,4};
        int x =1;

        System.out.println(Arrays.toString(occurrencesOfElement(nums , queries , x)));
    }
}
