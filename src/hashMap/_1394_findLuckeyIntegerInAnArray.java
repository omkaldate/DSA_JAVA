package hashMap;

import java.util.HashMap;
import java.util.Map;

public class _1394_findLuckeyIntegerInAnArray {
    public static void main(String[] args){
        int []arr = {1,2,2,2,3,3,3,4,5,6,6,6,6,6,7,4,5,5,5,};
        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {
        HashMap<Integer , Integer> mpp = new HashMap<>();
        int max =-1;

        for(int i=0; i<arr.length; i++){
            mpp.put(arr[i] , mpp.getOrDefault(arr[i] , 0)+1);
        }
        for(Map.Entry<Integer , Integer> i : mpp.entrySet()){
            if(i.getKey() == i.getValue()){
                max = Math.max(max , i.getKey());
            }
        }
        return max;
    }
}
