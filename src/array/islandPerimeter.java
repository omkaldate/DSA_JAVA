package array;

public class islandPerimeter {
    public static void main(String[] args){
        int[][]arr = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(islandPerimeter(arr));
    }

    public static int islandPerimeter(int[][] grid) {
            int perimeter=0;

            for(int i=0; i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++) {
                    if (grid[i][j] == 1) {
                        perimeter += isSafe(grid, i, j);
                    }
                }
            }
            return perimeter;
    }

    public static int isSafe (int[][] arr,int i , int j){
        int sum =4;

        if(j>0 && arr[i][j-1] ==1){
            sum = sum-2;
        }
        if(i>0 && arr[i-1][j] ==1){
            sum = sum-2;
        }
        return sum;
    }

}
