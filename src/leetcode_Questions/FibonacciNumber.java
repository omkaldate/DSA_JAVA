package leetcode_Questions;

public class FibonacciNumber {
    public static void main(String[] args){
        System.out.println(fib(5));
    }

    public static  int fib(int n) {
        if(n==0 ||n==1)return n;

        int t0=0;
        int t1=1;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr= t0+t1;
            t0=t1;
            t1=curr;
        }
        return curr;
    }
}

