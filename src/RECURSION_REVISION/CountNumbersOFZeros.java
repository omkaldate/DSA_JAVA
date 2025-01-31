package RECURSION_REVISION;

public class CountNumbersOFZeros {
    public static void main(String[] args) {
        System.out.println(fun(1020, 0));
    }

    public static int fun(int n , int ans){
        if(n%10 == n){
            if(n == 0) return ans+1;
            else return ans;
        }

        int rem = n%10;
        if(rem == 0) ans++;

        return fun(n/10 , ans);
    }
}
