package recursion;

public class sumOfDigits {
    public static void main(String[] args){
        int digit =1342;
        System.out.println(sum(digit));
    }

    public static int sum(int n){
        if(n%10 == n){
            return n;
        }
        return n%10 + sum(n/10);
    }
}
