package oopsCollage_practicals;

public class practical_3_2_ {
    public static void main(String[] args) {
        System.out.println("Name :  Om Balasaheb Kaldate");
        int count = 0; // Initialize count variable to keep track of the count of prime numbers

        // Loop through numbers from 1 to 50 and check for primality
        for (int i = 2; i <= 50; i++) {
            if (isPrime(i)) { // Check if the current number is prime
                count++; // If prime, increment count
            }
        }

        // Print the count of prime numbers from 1 to 50
        System.out.println("The count of prime numbers from 1 to 50 is: " + count);
    }

    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
