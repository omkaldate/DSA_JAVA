package slidingWindow;

import java.util.HashMap;

public class _992_SubArrayWithKDifferentIntegers_newApproach {
    public static void main(String[] args){
        int[]nums = {1,2,1,2,3};
        int k=2;
        System.out.println(atmost(nums,k) - atmost(nums,k-1));
    }

    public static int atmost(int nums[],int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        int i=0,j=0;

        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            while(map.size()>k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
            count += (j-i+1);
            j++;
        }
        return count;
    }
}
