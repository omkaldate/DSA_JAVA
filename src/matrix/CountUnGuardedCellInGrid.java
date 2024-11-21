package matrix;

import java.util.Arrays;

public class CountUnGuardedCellInGrid {

    public static int fun(int x, int y, int[][]matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt =0;

        int r = x;;
        int c = y;
        while(r-1 >= 0){
            if(matrix[r-1][c] ==2 || matrix[r-1][c] ==1) break;         // up
            if(matrix[r-1][c] == 0){
                matrix[r-1][c] = 3;
                cnt++;
            }
            r--;
        }

        r=x;
        c=y;
        while(c-1 >= 0){
            if(matrix[r][c-1] ==2 || matrix[r][c-1]== 1 ) break;             //left
            if(matrix[r][c-1] ==0){
                matrix[r][c-1] =3;
                cnt++;
            }
            c--;
        }

        r =x;
        c=y;
        while(r+1 <=m-1){   // down
            if(matrix[r+1][c] ==2 || matrix[r+1][c] ==1) break;
            if(matrix[r+1][c] ==0){
                matrix[r+1][c] =3;
                cnt++;
            }
            r++;
        }

        r =x;
        c=y;
        while(c+1 <= n-1){   //right
            if(matrix[r][c+1] ==2 || matrix[r][c+1] ==1) break;
            if(matrix[r][c+1] ==0){
                matrix[r][c+1] =3;
                cnt++;
            }
            c++;
        }

        return cnt;
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int g = guards.length;
        int w = walls.length;
        int rem = (m*n)-(g+w);

        int[][]matrix = new int[m][n];

        for(int[]garr : guards){
            int rg = garr[0];
            int cg = garr[1];
            matrix[rg][cg] = 1;
        }

        for(int[]warr : walls){
            int rw = warr[0];
            int cw = warr[1];
            matrix[rw][cw] = 2;
        }

        for(int[]arr : guards){
            int r = arr[0];
            int c = arr[1];

            rem -= fun(r,c,matrix);
        }
        for(int[]xx : matrix) System.out.println(Arrays.toString(xx));
        return rem;
    }


    public static void main(String[] args) {

    }
}
