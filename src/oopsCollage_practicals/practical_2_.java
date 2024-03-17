package oopsCollage_practicals;
import java.util.Scanner;
public class practical_2_ {
    public static void main(String[] args) {
        System.out.println("Name :  Om Balasaheb Kaldate");
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        int choice;

        System.out.println("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        num2 = scanner.nextDouble();

        System.out.println("Choose operation:\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Factorial");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Result: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0)
                    System.out.println("Result: " + (num1 / num2));
                else
                    System.out.println("Cannot divide by zero!");
                break;
            case 5:
                long factorial = 1;
                for (int i = 1; i <= num1; i++) {
                    factorial *= i;
                }
                System.out.println("Factorial of " + num1 + " is: " + factorial);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
