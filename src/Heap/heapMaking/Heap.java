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
               swap(parent,index);
                index = parent;
            }
            else return;
        }
    }

    void deletion(){
        if(size == 0){
            System.out.println("nothing to delete");
            return;
        }
       arr[1] = arr[size];  // swap
        size--;
        int i=1;
        while(i < size){
            int left = 2*i;
            int right = left+1;

            if(left<size && arr[left]>arr[i]){
                swap(left,i);
                i = left;
            }
            else if(right<size && arr[right]>arr[i]){
                swap(right,i);
                i = right;
            }
            else return;
        }
    }


    void print(){
        for(int i=1; i<=size; i++){
            System.out.println(arr[i]);
        }
    }

    void swap(int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
