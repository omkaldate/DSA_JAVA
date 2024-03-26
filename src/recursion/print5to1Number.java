package recursion;

public class print5to1Number {
    public static void main(String[] args){
   // fun(5);
    revfun(5);
    }

    public static void fun(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        fun(n-1);
    }

    public static void revfun(int n){
        if(n==0){
            return;
        }
        revfun(n-1);
        System.out.println(n);
    }

}
