package recursion_practice;

public class recursion_reverseTheInteger {

    public static void main(String[] args){

        reversal1(123456);
        System.out.println(num);


    }

    static int num=0;
    static void reversal1(int n){
        if(n==0){
            return;
        }
        int rem = n%10;
        num = num*10 +rem;
        reversal1(n/10);

    }
}
