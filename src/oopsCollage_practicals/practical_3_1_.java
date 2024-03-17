package oopsCollage_practicals;

import java.util.Scanner;
public class practical_3_1_ {
    public static void main(String[] args) {
        System.out.println("Name : Om Balasaheb Kaldate");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find its factorial: ");
        int number = scanner.nextInt();

        long factorial = calculateFactorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);

        scanner.close();
    }

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
