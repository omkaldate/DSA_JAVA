package stack;

import java.util.HashSet;

public class HappyNumber {
    public static long square(long num){
        long sum =0;
        while(num > 0){
            long rem = num%10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }

  

    public static void main(String[] args) {
        System.out.println();
    }
}
