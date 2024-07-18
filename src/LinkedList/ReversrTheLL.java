package LinkedList;

public class ReversrTheLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.helperReverse();
        list.display();

    }
}
