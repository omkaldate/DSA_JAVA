package set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        set.add(15);
        set.add(10);
        set.add(10);
        set.remove(10);

        for(int a : set) {
            System.out.println(a);
        }

        System.out.println(set);

        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        System.out.println(uniqueOccurrences(arr));
    }




    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
            int value = mp.getValue();
            set.add(value);
        }

        System.out.println(set);

        return map.size() == set.size();
    }
}
