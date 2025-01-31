package RECURSION_REVISION;

public class print1ton {
    public static void main(String[] args) {
        fun(5);
    }

    public static void fun(int n){
        if(n == 0) return;

        fun(n-1);
        System.out.println(n);
    }
}
