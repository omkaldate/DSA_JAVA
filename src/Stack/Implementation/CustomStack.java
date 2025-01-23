package Stack.Implementation;

public class CustomStack {
    protected int[]data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    CustomStack(){
        this(DEFAULT_SIZE);
    }

    CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("the stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }
    public int pop() throws stackException{
        if(isEmpty()){
            throw new stackException("cannot pop its empty");
        }
        return data[ptr--];
    }
    public int peek() throws stackException{
        if(isEmpty()){
            throw new stackException("cannot peek its empty");
        }
        return data[ptr];
    }


    private boolean isFull(){
        if(data.length-1 == ptr) return true;
        return false;
    }
    private boolean isEmpty(){
        if(-1 == ptr) return true;
        return false;
    }

}
