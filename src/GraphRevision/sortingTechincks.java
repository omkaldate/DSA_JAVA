package GraphRevision;

import java.util.ArrayList;
import java.util.Collections;

public class sortingTechincks {
    static class Tuple{
        int first;
        int second;
        Tuple(int a , int b){
            first = a;
            second = b;
        }
    }

    public static void main(String[] args) {
            ArrayList<Tuple>  list = new ArrayList<>();
            list.add(new Tuple(5,6));
            list.add(new Tuple(1,9));
            list.add(new Tuple(100,50));

            Collections.sort(list , (a, b) -> b.first - a.first);

            for(Tuple t : list){
                System.out.println(t.first + " " + t.second);
            }
    }
}
