package LinkedList.SingleLL;

public class Main {

    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertFirst(50);
        list.insert(1,100);
        list.insertLast(200);
        list.deleteFirst();
        list.delete(1);
        list.deleteLast();


        list.print();
    }
}
