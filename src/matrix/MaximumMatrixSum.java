package matrix;

public class MaximumMatrixSum {
    public static long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int neg = 0;
        int minAbsVal = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int val = matrix[i][j];
                sum += Math.abs(val);
                if (val < 0) neg++;

                minAbsVal = Math.min(minAbsVal, Math.abs(val));
            }
        }

        if (neg % 2 != 0) sum -= 2 * minAbsVal;
        return sum;
    }

    public static void main(String[] args) {

    }
}
