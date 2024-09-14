package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class comparator_ {

    static class bird{
        String name;
        int age;

        bird(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String toString(){
            return "name= " + name + " age= " + age + "\n" ;
        }
    }

   static class mycustomcompare implements Comparator<bird>{
        @Override
        public int compare(bird o1, bird o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        bird a1 = new bird("dog8" , 100);
        bird a2 = new bird("dog2" , 10);

        ArrayList<bird> list = new ArrayList<>();

        list.add(a1);
        list.add(a2);

//        Collections.sort(list, new Comparator<bird>() {
//            @Override
//            public int compare(bird o1, bird o2) {
//                return o1.age - o2.age;
//            }
//        });

//        Collections.sort(list, new mycustomcompare());

        Collections.sort(list , (b1,b2) -> b1.age-b2.age);
        System.out.println(list);
    }
}
