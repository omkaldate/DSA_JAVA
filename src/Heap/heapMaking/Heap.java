package Heap.heapMaking;


public class Heap {
    int [] arr = new int[20];
    int size;

    Heap(){
        arr[0] = -1;
        size = 0;
    }

    void insert(int val){
        size++;
        int index = size;
        arr[index] = val;

        while(index > 1){
            int parent = index/2;

            if(arr[parent] < arr[index]){
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            }
            else return;
        }
    }

    void print(){
        for(int i=1; i<size; i++){
            System.out.println(arr[i]);
        }
    }

    boolean deletion(int val){

    }

}
