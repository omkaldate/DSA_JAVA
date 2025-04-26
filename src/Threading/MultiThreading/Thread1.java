package Threading.MultiThreading;

public class Thread1 extends Thread{

    public Thread1(String s ){
        super(s);
    }

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println(i +" " +"inside "+ Thread.currentThread().getName());
        }
    }
}
