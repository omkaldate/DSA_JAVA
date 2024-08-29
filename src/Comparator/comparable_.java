package Comparator;

import java.util.ArrayList;
import java.util.Collections;

public class comparable_ {

    static class animal implements Comparable<animal>{
        String name;
        int age;

        animal(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String toString(){
            return "name= " + name + " age= " + age + "\n" ;
        }

        @Override
        public int compareTo(animal obj) {
            if(this.age == obj.age){
                return this.name.compareTo(obj.name);
            }
           return this.age - obj.age;
        }
    }


    public static void main(String[] args) {
        animal a1 = new animal("dog8" , 100);
        animal a2 = new animal("dog2" , 100);
        animal a3 = new animal("dog3" , 1);
        animal a4 = new animal("dog4" , 30);

        ArrayList<animal> list = new ArrayList<>();

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);

        Collections.sort(list);
        System.out.println(list);
    }
}
