package hashMap;

import java.util.HashMap;

public class HashingCode {
    public static void main(String[] args){
        int[] arr = {1,2,3,1,3,2,12};
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i=0;  i<arr.length; i++){
           mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(mpp);
    }
}
