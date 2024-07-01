package queue.implementQueue;

public class main {
    public static void main(String[] args) throws QueueException{

        customQueue cq = new customQueue(5);
        cq.insert(4);
        cq.insert(5);
        cq.insert(6);
        cq.insert(7);
        cq.insert(8);

        cq.display();

        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
    }
}
