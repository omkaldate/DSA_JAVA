package RECURSION_REVISION;

public class factorial {
    public static void main(String[] args) {
        System.out.println(fun(5));
    }

    public static int fun(int n){
        if(n == 1) return 1;

        return n * fun(n-1);
    }
}
