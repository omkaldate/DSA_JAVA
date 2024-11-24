package matrix;

import java.util.Arrays;

public class rotatingTheBox {

    public static char[][] fun(char[][] matrix){
            int n = matrix.length;
            int m = matrix[0].length;

            // Step 1: Rotate the matrix by 90 degrees clockwise
            char[][] rotated = new char[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rotated[j][n - 1 - i] = matrix[i][j];
                }
            }

            for (int col = 0; col < rotated[0].length; col++) {
                int emptyRow = rotated.length - 1;
                for (int row = rotated.length - 1; row >= 0; row--) {
                    if (rotated[row][col] == '#') {
                        rotated[row][col] = '.';
                        rotated[emptyRow][col] = '#';
                        emptyRow--;
                    }
                    else if (rotated[row][col] == '*') {
                        emptyRow = row - 1;
                    }
                }
            }

            return rotated;
    }

    public static void main(String[] args) {
        char[][]matrix= {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };

        matrix = fun(matrix);

        for(char[]x: matrix){
            System.out.println(Arrays.toString(x));
        }
    }
}
