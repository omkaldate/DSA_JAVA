package LinkedList;

public class InsertUsingRecursion {
    public static class LL {
        Node head;
        Node tail;

        protected class Node {
            private int value;
            private Node next;

            public Node(int val) {
                this.value = val;
            }

            public Node(int val,Node next) {
                this.value = val;
                this.next = next;
            }
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " --> ");
                temp = temp.next;
            }
            System.out.println(" null ");
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

        // method for recursion insert
        public void insert(int val , int index){
            head = recur(val,index,head);
        }

        private Node recur(int val , int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            return temp;
        }
            node.next = recur(val,index-1,node.next);
           return node;
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
        list.insert(3,4);
        list.display();
    }
}
