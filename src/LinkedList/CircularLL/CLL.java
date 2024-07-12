package LinkedList.CircularLL;

public class CLL {
    Node head;
    Node tail;

    CLL(){
        this.head = null;
        this.tail = null;
    }

    protected class Node{
        int value;
        Node next;

        Node(int val){
            this.value = val;
        }
        Node(int val , Node next){
            this.value = val;
            this.next = next;
        }
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display(){
        Node temp = head;
        if(temp != null) {
             do{
                 System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while (temp != head);

            System.out.println(" tail ");
        }
    }

    public void delete(int val){
        Node node = head;
        if(node == null) return;
        if(node.value == val){
            head = head.next;
            tail.next = head;
            return;
        }
        do{
            Node n = node.next;
            if(n.value == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node != head);
    }
}
