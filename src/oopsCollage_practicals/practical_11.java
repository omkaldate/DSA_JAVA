package oopsCollage_practicals;

interface Vehicle {
    void start();
    void stop();
}

// Implement the interface in a class
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started.");
    }
    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }
}
public class practical_11 {
    public static void main(String[] args){
        System.out.println("Name :  Om Balasaheb Kaldate");
        System.out.println();
        Car myCar = new Car();
        myCar.start();
        myCar.stop();
    }
}
