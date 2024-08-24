package Heap.heapMaking;

public class Main {

    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.insert(50);
        hp.insert(55);
        hp.insert(53);
        hp.insert(52);
        hp.insert(54);
        hp.print();

        System.out.println();

        hp.deletion();
        hp.print();
    }
}
