package stack;

import java.util.HashSet;

public class HappyNumber {
    public static int square(int num){
        int sum =0;
        while(num > 0){
            long rem = num%10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = square(slow);
            fast = square(square(fast));

        }while(slow != fast);

        if(slow == 1) return true;
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
