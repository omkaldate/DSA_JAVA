package Threading.MultiThreading;

public class Stack {
    private int[]array;
    private int size;
    Object lock;

    Stack(int n ){
        this.array = new int[n];
        this.size = -1;
        lock = new Object();
    }

    static public void fun(){
        synchronized(Stack.class) {
            System.out.println("in the static method");
        }
    }

    public boolean push(int val){
        synchronized (lock) {
            if (isFull()) return false;
            this.size++;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }

            this.array[size] = val;
            return true;
        }
    }

    public int pop(){
        synchronized (lock) {
            if (isEmpty()) {
                System.out.println(Integer.MIN_VALUE);
                return Integer.MIN_VALUE;
            }
            int val = this.array[size];
            this.array[size] = Integer.MIN_VALUE;

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }

            this.size--;
            return val;
        }
    }

    public boolean isFull(){
       return this.size == this.array.length-1;
    }

    public boolean isEmpty(){
       return this.size == -1;
    }
}

