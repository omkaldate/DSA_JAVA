package oops_oneShot;

interface parentInterface {
    public int var1 = 10;
    public void printInterface();
}

class Parent {
    public void printA(){
        System.out.println("Parent");
    }

    public final void password(){
        System.out.println("OM");
    }
}

class Child extends Parent  {
    public void printB() {
        System.out.println("Child");
    }

    public void printA() {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println("Parent Child");
        password();
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Child obj = new Child();
        Parent obj1 = new Parent();
        obj.printA();
        obj1.printA();
    }
}
