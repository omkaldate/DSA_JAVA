package queue.implementQueue;

import java.util.Arrays;

public class customQueue {
    private int[]data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    public customQueue(){
        this(DEFAULT_SIZE);
    }
    public customQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){                           //isFull
        return end == data.length;
    }
    private boolean isEmpty(){                         //isEmpty
        return end == 0;
    }

    public boolean insert(int item)throws QueueException{                   // insert
        if(isFull()){
            throw new QueueException("queue is full");
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws QueueException{                  // remove
        if(isEmpty()){
            throw new QueueException("Queue is empty");
        }
        int removed = data[0];
        for(int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;

        return removed;
    }

    public int front()throws QueueException{                   //front
        if(isEmpty()){
            throw new QueueException("queue is empty");
        }
        return data[0];
    }

    public void display(){
        for(int i=0; i<end; i++){
            System.out.println(data[i] +" ");
        }
        System.out.println("end");
    }

}
