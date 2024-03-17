package oops_oneShot;


class Student{
    int age;
    String name;

    Student(){
    }

    Student(Student obj3){
        this.age = obj3.age;
        this.name = obj3.name;
    }

    public void printinfo(){
        System.out.println(age);
        System.out.println(name);
    }
    void printinfo(int age){

        System.out.println(" printing the 1 age = " + age);
    }

    void printinfo(int age , String name){

        System.out.println("ptinting 2 function = " + age +" "+ name);
    }
    void printinfo(String name){

        System.out.println("printing 3 function = " + name);
    }

}

public class polimorphism {
    public static void main(String[] args) {
        Student obj = new Student();
       obj.age = 30;
       obj.name = "omya";
      obj. printinfo();

       Student obj1 = new Student(obj);
       obj1.printinfo();

       obj1.printinfo(obj1.age);
       obj.printinfo(obj1.age , obj1.name);
       obj1.printinfo(obj1.name);
    }
}
