package bitManipulation;

import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberofEqualRows {

    //  public int maxEqualRowsAfterFlips(int[][] matrix) {
    //     int n = matrix[0].length;
    //     int maxRows = 0;

    //     for (int[] currRow : matrix) {
    //         int[] inverted = new int[n];
    //         int count = 0;

    //         for (int col = 0; col < n; col++) {
    //             inverted[col] = currRow[col] == 0 ? 1 : 0;
    //         }

    //         for (int[] row : matrix) {
    //             if (Arrays.equals(row, currRow) || Arrays.equals(row, inverted)) {
    //                 count++;
    //             }
    //         }
    //         maxRows = Math.max(maxRows, count);
    //     }
    //     return maxRows;
    // }



    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<String, Integer> rowPatterns = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder rowPattern = new StringBuilder();
            int firstVal = row[0];

            for (int col = 0; col < n; col++) {
                rowPattern.append(row[col] == firstVal ? "S" : "B");
            }

            rowPatterns.put(rowPattern.toString(), rowPatterns.getOrDefault(rowPattern.toString(), 0) + 1);
        }

        int maxRows = 0;
        for (int count : rowPatterns.values()) {
            maxRows = Math.max(maxRows, count);
        }
        return maxRows;
    }



    public static void main(String[] args) {

    }
}
