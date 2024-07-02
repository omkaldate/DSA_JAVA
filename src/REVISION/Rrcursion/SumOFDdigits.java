package REVISION.Rrcursion;

public class SumOFDdigits {

    public static int sum(int n){
        if(n%10 == n) return n;

        int digit = n%10;
        return digit+sum(n/10);
    }

    public static void main(String[] args) {
        System.out.println(sum(1234));
    }
}
