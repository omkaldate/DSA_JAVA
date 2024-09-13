package Graph;

import java.util.Arrays;

public class FloysWorshallAlgorithm {
    public static void shortest_distance(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -1) matrix[i][j] = (int) 1e9;
                if( i == j) matrix[i][j] = 0;
            }
        }

        for(int vis =0; vis<n; vis++){
            for(int i=0; i<n; i++){
                for(int j =0; j<n; j++){
                    matrix[i][j] = Math.min(matrix[i][j] , (matrix[i][vis] + matrix[vis][j]));
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1e9) matrix[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[][]arr = {
                {0,3,-1,7},
                {8,0,2,-1},
                {5,-1,0,1,},
                {2,-1,-1,0}
        };

        shortest_distance(arr);

        for(int[]x : arr){
            System.out.println(Arrays.toString(x));
        }
    }

}
