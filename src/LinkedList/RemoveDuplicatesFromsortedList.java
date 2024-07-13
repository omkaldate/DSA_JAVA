package LinkedList;

import java.util.LinkedList;

public class RemoveDuplicatesFromsortedList {
    public static class LL {
        Node head;
        Node tail;

        protected class Node {
            private int value;
            private Node next;

            public Node(int val) {
                this.value = val;
            }

            public Node(int val, Node next) {
                this.value = val;
                this.next = next;
            }
        }

        public void insertLast(int val){
            if(head == null){
               Node node = new Node(val);
               head = node;
               tail = node;
                return;
            }
            Node node = new Node(val);
            tail.next = node;
            tail = node;
        }

        public void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.value + " --> ");
                temp = temp.next;
            }
            System.out.println(  " null ");
        }

       // class for function
        public void deleteDuplicates() {
            Node temp = head;
            if (temp == null) return;
            while (temp.next != null) {
                if (temp.value == temp.next.value) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
        }

    }

    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(4);
        list.insertLast(4);
        list.display();
        list.deleteDuplicates();
        list.display();


    }

}
