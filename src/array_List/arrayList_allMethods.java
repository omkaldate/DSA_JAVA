package array_List;
import java.util.*;
import java.util.ArrayList;

public class arrayList_allMethods {
    public static void main(String[] args){

        ArrayList<Integer> l1 = new ArrayList<>();

        l1.add(10);
        l1.add(30);
        l1.add(20);
        System.out.println(l1.contains(10));
        System.out.println(l1.indexOf(30));
        Collections.sort(l1);
        System.out.println(l1);
        System.out.println(l1.size());

        l1.add(1 , 1000);
        System.out.println(l1.get(1));
        System.out.println(l1);
        l1.remove(1);

        ArrayList<Integer> l2 = new ArrayList<>();

        l2.addAll(l1);
        l2.set(1 , 56);
//l1.clear();
        System.out.println(l1);
        System.out.println(l2);

    }
}
