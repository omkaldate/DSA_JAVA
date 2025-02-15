package ATest;

class Parent {
    int a;
    int b;
    int z = 10;
    Parent(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void parentM() {
        System.out.println(z);
        System.out.println("hello");
    }
}

class Child extends Parent{
    int c;
    int d;

    Child(int a, int b, int c, int d) {
        super(a, b);
        this.c = c;
        this.d = d;
    }

    public void parentM() {
        this.z = 20;
        System.out.println(z);
    }
}

public class Demo {
    public static void main(String[] args) {
        Parent p = new Child(1, 2, 3, 4);
//        System.out.println(p.parentM());
        p.parentM();
    }

}
