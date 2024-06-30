package custom_Generics.arrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class customArraylst {
    private int[] data;
    private static int DEFAULT_SIZE=10;
    private int size =0;

    public customArraylst(){
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int[]temp = new int[data.length*2];
        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        data=temp;
    }

    private boolean isFull(){
        return size == data.length;
    }

    public int remove(){
         int removed = data[size--];
         return removed;
    }

    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index , int value){
        data[index] = value;
    }
    @Override
    public String toString(){
        return "customArrayList(" +"data=" + Arrays.toString(data) +", size="+size +")";
    }


    public static void main(String[] args) {
       // ArrayList list =

        customArraylst list = new customArraylst();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(list);
        list.remove();
        list.set(1,10);
        System.out.println(list);
    }
}
