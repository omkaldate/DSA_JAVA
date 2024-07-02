package REVISION.Rrcursion;

public class reverseAnumber {

    public static int reverse(int n){
        int digits = (int)Math.log10(n)+1;
        return helper(n,digits);
    }

    public static int helper(int n , int digits){
        if(n%10 == n) return n;

        int remender = n%10;
        int sum = remender *(int) Math.pow(10,digits-1);
        return sum + helper(n/10 , digits-1);

    }

    public static void main(String[] args) {

        System.out.println(reverse(1234));
    }
}
