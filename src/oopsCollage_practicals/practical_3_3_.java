package oopsCollage_practicals;
import java.util.Scanner;
public class practical_3_3_ {
    public static void main(String[] args) {
        System.out.println("Om Balasaheb Kaldate");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            int num = scanner.nextInt();
            sum += num;
        }

        double average = (double) sum / n;

        System.out.println("Sum of the numbers: " + sum);
        System.out.println("Average of the numbers: " + average);

        scanner.close();
    }
}
