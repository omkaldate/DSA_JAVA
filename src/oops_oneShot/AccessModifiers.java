package oops_oneShot;

class Person {
    private String name;
    private int age;
    private static int count = 0;

    public void setData(String n, int a) {
        this.name = n;
        this.age = a;
        count++;
    }

    public static void demo() {
        count = 12;
        System.out.println("Count in static " + count);
    }

    public void getData() {
        System.out.println(name + " " + age + " " + count);
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        Person p = new Person();
        Person p1 = new Person();
        p.setData("Om", 19);
        p.getData();
        p1.setData("Om1", 19);
        p1.getData();

        Person.demo();

        demo1();
    }

    public static void demo1() {
        System.out.println("demo1");
    }
}
