package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int numSteps = 1;
        int totalCells = rows * cols;
        List<int[]> result = new ArrayList<>();
        int r = rStart, c = cStart;
        int d = 0;

        while (result.size() < totalCells) {
            for (int i = 0; i < 2; i++) {        // it increase whe north to south & south to easth
                for (int j = 0; j < numSteps; j++) {
                    if (0 <= r && r < rows && 0 <= c && c < cols) {
                        result.add(new int[]{r, c});
                    }
                    if (result.size() == totalCells) {
                        return convert(result);
                    }
                    r += directions[d][0];
                    c += directions[d][1];
                }
                d = (d+1) % 4;
            }
            numSteps++;
        }
        return convert(result);
    }


    private static int[][] convert(List<int[]> list) {
        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }




    public static void main(String[] args) {
        int[]arr = {1,2,3,4};
       int[][]x = spiralMatrixIII(1,4,0,0);

       for(int[] one: x){
           System.out.println(Arrays.toString(one));
       }
    }
}
