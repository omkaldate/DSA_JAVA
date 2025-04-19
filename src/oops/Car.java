package oops;

public class Car implements Break{


    @Override
    public void start() {
        System.out.println(" start in car class");
    }

    @Override
    public void stop() {
        System.out.println("stop in car class");
    }


    public static void main(String[] args) {
        Car obj = new Car();
        obj.start();
        obj.stop();
    }
}
