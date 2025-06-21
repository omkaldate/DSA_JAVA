package CoreJava;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class MemoryManagement {
    static class Person{

    }

    private void memoryManagementTest(Person personObj){
        Person personObj2 = personObj;
        String stringLiteral2 ="24";
        String stringLiteral3 = new String("24");
    }


    public static void main(String[] args) {
        int primitiveVariable = 10;
        Person personObj = new Person();
        WeakReference<Person> weakobj = new WeakReference<Person>(new Person());
        SoftReference<Person> softobj = new SoftReference<Person>(new Person());
        String stringLiteral = "24";
        MemoryManagement memObj = new MemoryManagement();
        memObj.memoryManagementTest(personObj);
    }
}
