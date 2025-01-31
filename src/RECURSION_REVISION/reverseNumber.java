package RECURSION_REVISION;

public class reverseNumber {
    public static void main(String[] args) {
        System.out.println(fun(12345, 0));
    }

    public static int fun(int n, int sum){
        if(n%10 == n){
            sum = (sum*10)+n;
            return sum;
        }

        int rem = n%10;
        sum = (sum*10)+rem;
       return fun(n/10 , sum);
    }
}
