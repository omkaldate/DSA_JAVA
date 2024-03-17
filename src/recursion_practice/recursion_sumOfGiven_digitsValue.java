package recursion_practice;

public class recursion_sumOfGiven_digitsValue {
    public static void main(String[] args){

        System.out.println(456%10); // ---> 6
        System.out.println(456/10); // ---> 45

        int ans = sum(12345);
        System.out.println(ans);

    }

    static int sum(int n){
        if(n ==0){
            return 0;
        }

        return (n%10) + sum(n/10);

    }
}
