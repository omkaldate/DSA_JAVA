package leetCodeContest.Biweekly130;

public class checkIfGridSatisfiesConditions {
    public static boolean satisfiesConditions(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if( j+1 < grid[0].length && grid[i][j] == grid[i][j+1]) return false;

                if(! isSame(j , grid)) return false;

            }
        }
        return true;
    }

    public static boolean isSame(int j , int[][]grid){
        int x=grid[0][j];
        for(int i=0; i<grid.length; i++){
            if(grid[i][j] !=  x ) return false;
        }
        return true;
    }


    public static void main(String[] args){
        int[][]grid = {
                {1,0,2},
                {1,0,2}
        };
        System.out.println(satisfiesConditions(grid));
    }
}
