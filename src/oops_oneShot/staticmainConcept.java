package oops_oneShot;

import com.sun.tools.javac.Main;

public class staticmainConcept {
    public static void main(String[] args){
        System.out.println("hello");

        staticmainConcept obj = new staticmainConcept();
        obj.greeting();
    }


    void greeting(){
        System.out.println("inside thr greeting");
    }

    void fun2(){
        greeting();
    }
}
