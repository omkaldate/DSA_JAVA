package REVISION.Rrcursion;

public class NumbersOfZeros {

    public static int zeros(int n , int cnt) {
        if (n % 10 == n){
            if(n == 0)return cnt+1;
            return cnt;
        }

        if ( n % 10 == 0) {
          return zeros(n/10 , cnt+1);
        }
        return zeros(n/10, cnt);
    }


    public static void main(String[] args) {
        System.out.println(zeros(102034,0));
    }
}
