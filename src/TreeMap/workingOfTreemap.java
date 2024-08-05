package TreeMap;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class workingOfTreemap {
    public static void main(String[] args) {
        TreeMap<Integer , Character> mpp = new TreeMap<>();
        mpp.put(1,'a');
        mpp.put(10,'z');
        mpp.put(3,'c');
        mpp.put(4,'d');
        mpp.put(30,'t');

        System.out.println(mpp);

        mpp.forEach((a,b)-> {
            System.out.println(a+" " + b);
        }) ;

        System.out.println();
        for(int i : mpp.keySet()){
            System.out.println(i +" "+mpp.get(i));
        }

        System.out.println();
        System.out.println(mpp.subMap(3,10));

        System.out.println();
        for (Map.Entry<Integer, Character> e :mpp.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }


}
