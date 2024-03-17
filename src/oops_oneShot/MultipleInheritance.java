package oops_oneShot;

interface intA {
    public void A();
}

interface intB {
    public void A();
}

interface intC extends intB {
    public void C();
}

class Child2 implements intC {
    public void A() {

    }

    public void C() {

    }
}

class Child1 extends ParentA implements intA, intB {
    public void A() {
        System.out.println("Multiple");
    }

    public void B() {
        System.out.println("B");
    }
}

class ParentA{
    public void A() {
        System.out.println("Parent A");
    }
}

//class ParentB{
//    public void A() {
//        System.out.println("Parent B");
//    }
//}

public class MultipleInheritance {
    public static void main(String[] args) {
        Child1 obj = new Child1();
        obj.A();
        obj.B();
    }
}
