package stack;

public class stackImplement {
    protected int[] data;
    private static final int DEFAULT_SIZE =10;
    int ptr =-1;

    public stackImplement(){
        this(DEFAULT_SIZE);
    }

    public stackImplement(int size){
        this.data = new int[size];
    }
;
    public boolean push(int item){
        if(isFull()){
            System.out.println("stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("cannot pop from an empry stack");
        }
        return data[ptr--];
    }
    public int peek()throws StackException{
        if(isEmpty()){
            throw new StackException("cannot pop from an empry stack");
        }
        return data[ptr];
    }

    private boolean isFull(){
        return ptr == data.length-1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }


    public static void main(String[] args)throws StackException{
        stackImplement stack = new stackImplement(3);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        System.out.println(stack.pop());

    }
}
