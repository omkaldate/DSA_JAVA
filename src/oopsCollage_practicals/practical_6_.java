package oopsCollage_practicals;

import java.util.Scanner;
public class practical_6_ {
    public static void main(String[] args) {
        System.out.println("Name :  Om Balasaheb Kaldate");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for matrices: ");
        int columns = scanner.nextInt();

        // Initialize two matrices

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];
        int[][] sumMatrix = new int[rows][columns];

        // Input elements for first matrix
        System.out.println("Enter elements of the first matrix:");
        inputMatrixElements(scanner, matrix1);

        // Input elements for second matrix
        System.out.println("Enter elements of the second matrix:");
        inputMatrixElements(scanner, matrix2);

        // Add matrices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Display the sum matrix
        System.out.println("Sum of the matrices:");
        displayMatrix(sumMatrix);

        scanner.close();
    }

    // Method to input matrix elements
    public static void inputMatrixElements(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Method to display matrix elements
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
