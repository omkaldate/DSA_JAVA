package recursion_practice;

public class fibonacchi_recursion {
    public static void main(String [] args){

        int n=3;
        System.out.println(fiboFind(n));

    }

    static int fiboFind(int n){
        if(n < 2){
            return n;
        }

        return fiboFind(n-1) + fiboFind(n-2);
    }
}