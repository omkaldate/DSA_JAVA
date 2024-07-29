package Maths;

import java.util.Arrays;

public class CountPairs {
        public static int countPrimes(int n) {
            if(n <= 1) return 0;

            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true);

            for(int i = 2; i <= n; i++) {
                if(isPrime[i]) {
                    for(int j = i * 2; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            int count = 0;

            for(int i = 2; i < n; i++) {
                if(isPrime[i]) {
                    count++;
                }
            }
            return count;
        }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
