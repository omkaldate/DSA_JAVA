package LinkedList.DoubleLL;

public class DLL {
    protected Node head;

   protected class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
        Node(int value , Node next , Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
   }

    public void insertFirst(int val){
       Node node = new Node(val);
       node.next = head;
       node.prev = null;
       if(head != null) head.prev = node;
       head = node;
    }

    public void display(){
       Node temp = head;
       while(temp != null){
           System.out.print(temp.value + " -> ");
           temp = temp.next;
       }
        System.out.println(" null ");
    }

    public void insertLast(int val){
       if(head == null){
           Node node = new Node(val);
           head = node;
           return;
       }
       Node temp = head;
       while(temp.next !=null){
           temp = temp.next;
       }
        Node node = new Node(val);
        temp.next = node;
        node.prev = temp;
    }

    public Node find(int val){
       Node temp = head;
       while(temp != null){
           if(temp.value == val) return temp;
           temp = temp.next;
       }
       return null;
    }

    public void insert(int after , int val){
       Node p = find(after);
       if(p == null){
           System.out.println("does not exit");
           return;
       }
       Node node = new Node(val);
        node.next = p.next;
        node.prev = p;
        p.next = node;
        if(node.next != null) node.next.prev = node;
    }
}
