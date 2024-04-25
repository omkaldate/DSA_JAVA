package hashMap;

import java.util.HashMap;

public class containsDuplicate_II {
    public static void main(String[] args){
        int[]arr = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(arr , 3));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k){
                return true;
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
