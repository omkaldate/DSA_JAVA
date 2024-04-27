package leetCodeContest.Biweekly129;

public class makeASquareWithTheSameColour {
    public static void main(String[] args){

        char[][] grid ={
                {'B' , 'W' , 'B'},
                {'W' , 'B' , 'W'},
                {'B' , 'W' , 'B'}
        };
        System.out.println(canMakeSquare(grid));

    }

    public static boolean canMakeSquare(char[][] grid) {
        int b=0;
        int w=0;

        //for firsh 4x grid
        for(int i=0; i<2; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == 'B') b++;
                else {
                    w++;
                }
            }
        }
        if(b ==4 && w==0 || b==0 && w==4) return true;
        if(b==1 && w==3 || b==3 && w==1) return true;
        b=0 ;
        w=0;


        //for second 4x grid
        for(int i=0; i<2; i++){
            for(int j=1; j<3; j++){
                if(grid[i][j] == 'B') b++;
                else{
                    w++;
                }
            }
        }
        if(b ==4 && w==0 || b==0 && w==4) return true;
        if(b==1 && w==3 || b==3 && w==1) return true;
        b=0 ;
        w=0;


        //for third 4x grid
        for(int i=1; i<3; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == 'B') b++;
                else {
                    w++;
                }
            }
        }
        if(b ==4 && w==0 || b==0 && w==4) return true;
        if(b==1 && w==3 || b==3 && w==1) return true;
        b=0 ;
        w=0;

        //for forth 4x grid
        for(int i=1; i<3; i++) {
            for (int j = 1; j < 3; j++) {
                if (grid[i][j] == 'B') b++;
                else {
                    w++;
                }
            }
        }
        if(b ==4 && w==0 || b==0 && w==4) return true;
        if(b==1 && w==3 || b==3 && w==1) return true;
        b=0 ;
        w=0;

        return false;
    }

}
