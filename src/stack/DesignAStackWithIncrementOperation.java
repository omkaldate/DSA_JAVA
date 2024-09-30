package stack;

public class DesignAStackWithIncrementOperation {

     static class CustomStack {

        int size ;
        int[]arr;
        public CustomStack(int maxSize) {
            arr = new int[maxSize];
            size = 0;
        }

        public void push(int x) {
            if(size < arr.length){
                arr[size] = x;
                size++;
            }
        }

        public int pop() {
            if(size != 0){
                size--;
                return arr[size];
            }
            return -1;
        }

        public void increment(int k, int val) {
            int n = (size < k) ? size : k;

            for(int i=0; i<n; i++){
                arr[i] += val;
            }
        }
    }


    public static void main(String[] args) {
        CustomStack obj = new CustomStack(5);


    }
}
