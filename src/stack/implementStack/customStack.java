package stack.implementStack;

public class customStack {
    protected int[]data;
    private static final int DEFAULT_SIZE =10;
    int ptr =-1;


    public customStack(){
        this(DEFAULT_SIZE);
    }
    public customStack(int size){
        this.data = new int[size];
    }

    public int getTop() {
        if (ptr < 0) {
            System.out.println("Stack underflow");
        }
        return data[ptr];
    }

    public boolean push(int item){                       // push
        if(isFull()){
            System.out.println("stack is full");
            return false;
        }
        data[++ptr] = item;
        return true;
    }
    public boolean isFull(){
        return ptr == data.length-1;
    }

    public int pop()throws StackException{                 // pop
        if(isEmpty()) {
           throw new StackException("stack is empty for pop");
        }
       return data[ptr--];
    }
    private boolean isEmpty(){
        return ptr == -1;
    }

    public int peek()throws StackException{                 // peek
        if(isEmpty()) {
            throw new StackException("stack is empty for peek");
        }
        return data[ptr];
    }

}
