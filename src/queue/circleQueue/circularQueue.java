package queue.circleQueue;

public class circularQueue {
    protected int[]data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front =0;
    private int size = 0;


    public circularQueue(){
        this(DEFAULT_SIZE);
    }
    public circularQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){                           //isFull
        return size == data.length;
    }
    private boolean isEmpty(){                         //isEmpty
        return size == 0;
    }

    public boolean insert(int item)throws QueueException {                   // insert
        if(isFull()){
            throw new QueueException("queue is full");
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws QueueException{                  // remove
        if(isEmpty()){
            throw new QueueException("Queue is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front()throws QueueException{                   //front
        if(isEmpty()){
            throw new QueueException("queue is empty");
        }
        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("is empty in display");
            return;
        }
       int i = front;
       do{
           System.out.print (data[i] + " ->");
           i++;
           i %= data.length;
       } while(i != end);
            System.out.println("end");
    }
}
