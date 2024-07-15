package LinkedList.Bubble;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(3);
        list.insertLast(1);
        list.insertLast(2);
        list.display();  // Before sorting
        list.sort();
        list.display();  // After sorting
    }
}
