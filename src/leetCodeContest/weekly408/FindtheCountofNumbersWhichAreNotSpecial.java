package leetCodeContest.weekly408;

import java.util.Arrays;

public class FindtheCountofNumbersWhichAreNotSpecial {
    public static int nonSpecialCount(int l, int r) {
        int N = (int) Math.sqrt(r);

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= N; i++) {
            if(isPrime[i] == true) {
                for(int j = 2 * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i <= N; i++) {
            if(isPrime[i]) {
                int square = i * i;

                if(l <= square && square <= r) {
                    count++;
                }
            }
        }

        int total = r - l + 1;
        return total - count;
    }

    public static void main(String[] args) {
        int l = 5;
        int r = 7;
        System.out.println(nonSpecialCount(l,r));

    }
}
