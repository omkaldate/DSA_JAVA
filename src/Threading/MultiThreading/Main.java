package Threading.MultiThreading;

public class Main {
    public static void main(String[] args) {
        System.out.println("starting of main");

//        Thread thread1 = new Thread1("thread1");
//        thread1.setDaemon(true);
//        thread1.start();


//        Thread obj = new Thread(new Thread2(), "thread2");
//         obj.setDaemon(false);
//        obj.start();

//        Thread obj = new Thread(() ->{            // used the theta in this
//            for(int i=0; i<5; i++){
//                System.out.println(i +" " +"inside "+ Thread.currentThread().getName());
//            }
//        },"onjT 1");
//
//        obj.setDaemon(false);
//        obj.start();


        // ****************** Sysnchronization**********************
//        Stack stk = new Stack(5);
//
//        new Thread(() ->{
//            int cnt =0;
//            while(++cnt < 10){
//                System.out.println("push  " + stk.push(100) +" thread name "+ Thread.currentThread().getName());
//                stk.fun();
//            }
//        },"pusher").start();
//
//        new Thread(() ->{
//            int cnt =0;
//            while(++cnt < 10){
//                System.out.println("pop  " + stk.pop() +" thread name "+ Thread.currentThread().getName());
//            }
//        },"poper").start();


        //*****************Producer Consumer **************************

//        BlockingQueue qu = new BlockingQueue(3);
//
//        new Thread(() ->{
//            int cnt =0;
//            while(++cnt < 10){
//                System.out.println("add  " + qu.add(100) +" thread name "+ Thread.currentThread().getName());
//            }
//        },"adder Thread ").start();
//
//        new Thread(() ->{
//            int cnt =0;
//            while(++cnt < 10){
//                System.out.println("remove  " + qu.remove() +" thread name "+ Thread.currentThread().getName());
//            }
//        },"remover Thread ").start();


        //****************** States of Thread*****************
//        Thread th =  new Thread(()->{
//                try {
//                    Thread.sleep(1);
//                    for(int i=0; i<100; i++);
//                }
//                catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//        },"th");
//        th.start();
//
//        while (true){
//            Thread.State st = th.getState();
//            System.out.println(st);
//            if(st == Thread.State.TERMINATED) break;
//        }


        //*****************Joins **************
//        Thread th = new Thread(()->{
//            System.out.println(Thread.currentThread());
//        },"thread th");
//        th.start();
//
//        try {
//                th.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }


        //**********Deadlock**************
        String a = "aa";
        String b = "bb";

        Thread th1 = new Thread(()->{
            synchronized (a){
                try{
                    Thread.sleep(1);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("lock avquired for th1");
                }
            }
        },"thread th1");

        Thread th2 = new Thread(()->{
            synchronized (b){
                try{
                    Thread.sleep(1);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("lock avquired for th2");
                }
            }
        },"thread th2");

        th1.start();
        th2.start();

        System.out.println("ending of main");
    }
}
