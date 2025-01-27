package LinkedList.SingleLL;

import java.sql.SQLOutput;

public class LL {
   private Node head;
   private Node tail;
   private int size;

   LL(){
      this.size = 0;
   }

   public void insertFirst(int data){
       Node node = new Node(data,head);
       head = node;
       if(tail == null) tail = head;
       this.size++;
   }
   public void insertLast(int data){
       if(tail == null) insertFirst(data);
       Node node = new Node(data);
       tail.next = node;
       this.size++;
   }

   public Node get(int ind){
       Node temp = head;
       if(this.size < ind+1){
           System.out.println("size of list is not that much");
           return null;
       }
       for(int i=0; i<ind; i++){
           temp = temp.next;
       }
       return temp;
   }

   public void insert(int ind , int data){
       Node temp = get(ind-1);
       if(temp == null){
           System.out.println("sorry node not added");
           return;
       }
       Node node = new Node(data);
       node.next = temp.next;
       temp.next = node;
       this.size++;
   }

   public void deleteFirst(){
       if(head == null) return;
       head = head.next;
       this.size--;
   }

   public void deleteLast(){
       if(tail == null) return;
       Node node = get(size-2);
       node.next = null;
       node = tail;
       this.size--;
   }
   public void delete(int ind){
       Node temp = get(ind-1);
       if(temp == null){
           System.out.println("sorry node not present");
           return;
       }
       temp.next = temp.next.next;
       this.size--;
   }

   public void print(){
       Node temp  = head;
       for(int i=0; i<size; i++){
           System.out.print(temp.val +" -> " );
           temp = temp.next;
       }
       System.out.println("End");
   }


    private class Node{
        private int val;
        private Node next;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
