package queue;

public class queueImplement {
    protected int[] data;
    private static final int DEFAULT_SIZE =10;
    int end =0;

    public queueImplement(){
        this(DEFAULT_SIZE);
    }

    public queueImplement(int size){
        this.data = new int[size];
    }

    private boolean isFull(){
        return end == data.length;
    }

    private boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("queue is empty");
        }
        int removed = data[0];
        //shift the elements to the left
        for(int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }
        return data[0];
    }


    public void display(){
        for(int i=0; i<end; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println("end");
    }


    public static void main(String[] args)throws Exception{
        queueImplement que = new queueImplement(3);
        que.insert(19);
        que.insert(34);
        que.display();
        System.out.println(que.remove());
        que.display();

    }

}
