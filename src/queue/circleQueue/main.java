package queue.circleQueue;

public class main {
    public static void main(String[] args) throws QueueException {

//        circularQueue cq = new circularQueue(5);
//        cq.insert(4);
//        cq.insert(5);
//        cq.insert(6);
//        cq.insert(7);
//        cq.insert(8);
//
//        System.out.println(cq.remove());
//        System.out.println(cq.remove());
//
//        cq.display();
//
//        System.out.println(cq.remove());
//        System.out.println(cq.remove());
//        System.out.println(cq.remove());

        dynamicQueue cq = new dynamicQueue(5);
        cq.insert(4);
        cq.insert(5);
        cq.insert(6);
        cq.insert(7);
        cq.insert(8);
        cq.insert(78);
        cq.insert(4);
        cq.insert(5);
        cq.insert(6);
        cq.insert(7);

        cq.display();

        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
    }
}
