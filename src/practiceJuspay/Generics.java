package practiceJuspay;

public class Generics <T> {

    int count;
    T[] arr;
    Generics(int x){
        this.count = 0;
        this.arr = (T[]) new Object[x];
    }

    public void add(T t) {
        arr[count++] = t;
    }

    public T get(int index) {
        return arr[index];
    }

    public static void main(String[] args) {
        Generics<Integer> e = new Generics<>(10);
        e.add(1);
        e.add(2);
        System.out.println(e.get(0));
        System.out.println(e.get(1));
    }
}
