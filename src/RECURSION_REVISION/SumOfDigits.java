package RECURSION_REVISION;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(fun(12345));
    }

    public static int fun(int n){
        if(n % 10 == n) return n;

        int rem  = n%10;

        return rem + fun(n/10);
     }
}
