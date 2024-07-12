package LinkedList.SingleLL;

public class Main {

    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertFirst(50);

        list.display();

        int deletedFirst = list.deleteFirst(); // Delete the first element
        System.out.println("Deleted first element: " + deletedFirst);
        list.display();

        int deletedLast = list.deleteLast(); // Delete the last element
        System.out.println("Deleted last element: " + deletedLast);
        list.display();

        int deletedAtIndex = list.delete(1); // Delete element at index 1
        System.out.println("Deleted element at index 1: " + deletedAtIndex);
        list.display();
    }
}
