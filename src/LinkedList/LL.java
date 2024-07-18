package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size=0;
    }

    private  class Node{
        private int value;
        private Node next;

        public Node(int val){
            this.value = val;
        }
        public Node(int val , Node next){
            this.value = val;
            this.next = next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null) tail = head;
        size++;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println(  " null ");
    }

    public void insert(int value , int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(value,temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null) tail = null;
        size--;
        return val;
    }

    public int deleteLast(){
        if(size <= 1) return deleteFirst();
        Node secondLast = get(size -1);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){
        if(index == 0) deleteFirst();
        if(index == size-1) deleteLast();
        Node prev = get(index -1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node get(int index){
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public Node find(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value) return temp;
            temp = temp.next;
        }
        return null;
    }


    public Node findMid(Node head){
        if(head == null || head.next == null) return head;
        Node slow =head;
        Node fast = head;

        while (fast != null && head.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    //*************  reverse the linkedList  *********************

    public void helperReverse(){
        this.head = reverse(this.head);
    }

    public Node reverse (Node head){
        if(head == null || head.next == null) return head;

        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

}
