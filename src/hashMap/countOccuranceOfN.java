package hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class countOccuranceOfN {
    public static void main(String[] args){

        int[] arr = {1, 4, 5, 8,5, 2};
        HashMap<Integer, Integer> Map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(Map.containsKey(arr[i])) {
                Map.put(arr[i], Map.get(arr[i]) + 1);
            }
            else {
                Map.put(arr[i], 1);
            }
        }

        System.out.println(Map);
        Set<Integer> key = Map.keySet();
        for(Integer i : key){
            System.out.println(i + " " + Map.get(i));
        }
    }
}
