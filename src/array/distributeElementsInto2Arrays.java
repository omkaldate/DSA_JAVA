package array;

import java.util.ArrayList;
import java.util.Arrays;

public class distributeElementsInto2Arrays {
    public static void main(String[] args){

        int[]nums = {5,4,3,8};

        ArrayList<Integer> arr1= new ArrayList<>();
        ArrayList<Integer> arr2= new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i=2;i<nums.length;i++){
            if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1)){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }
        System.out.println(Arrays.toString(result(arr1,arr2)));
    }


    private static int[] result(ArrayList<Integer> a1 ,ArrayList<Integer> a2){
        int[] ans=new int[a1.size() + a2.size()];
        int k=0;
        for(int i=0;i<a1.size();i++)
        {
            ans[k]=a1.get(i);
            k++;
        }
        for(int i=0;i<a2.size();i++)
        {
            ans[k]=a2.get(i);
            k++;
        }
        return ans;
    }
}
