package ATest;

import java.util.*;

public class PrimeSumInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rangeLeft = scanner.nextInt();
        int rangeRight = scanner.nextInt();

        int smallestPrime = Integer.MAX_VALUE;
        int largestPrime = Integer.MIN_VALUE;
        

        for (int i = rangeLeft; i <= Math.min(rangeRight, -1); i++) {
            if (i < smallestPrime) {
                smallestPrime = i;
            }
            if (i > largestPrime) {
                largestPrime = i;
            }
        }

        if (rangeRight >= 2) {
            int positiveLeft = Math.max(rangeLeft, 2);

            int limit = (int)Math.sqrt(rangeRight) + 1;
            List<Integer> smallPrimes = sieve(limit);

            boolean[] isPrimeInRange = new boolean[rangeRight - positiveLeft + 1];
            Arrays.fill(isPrimeInRange, true);

            for (int prime : smallPrimes) {
                int start = Math.max(prime * prime, (positiveLeft + prime - 1) / prime * prime);
                for (int j = start; j <= rangeRight; j += prime) {
                    isPrimeInRange[j - positiveLeft] = false;
                }
            }

            for (int i = 0; i < isPrimeInRange.length; i++) {
                if (isPrimeInRange[i]) {
                    int prime = i + positiveLeft;
                    if (prime < smallestPrime) {
                        smallestPrime = prime;
                    }
                    if (prime > largestPrime) {
                        largestPrime = prime;
                    }
                }
            }
        }

        if (smallestPrime == Integer.MAX_VALUE || largestPrime == Integer.MIN_VALUE) {
            System.out.println("No prime numbers in the given range");
        } else {
            int sum = smallestPrime + largestPrime;
            System.out.println(sum);
        }
    }


    public static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
