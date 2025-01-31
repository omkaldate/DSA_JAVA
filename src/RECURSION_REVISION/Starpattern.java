package RECURSION_REVISION;

public class Starpattern {
    public static void main(String[] args) {
        fun(4,0);
    }

    public static void fun(int row, int col){
        if( row == 0) return;

        if(col < row){
            System.out.print(" * ");
            fun(row, col+1);
        }
        else {
            System.out.println();
            fun(row - 1, 0);
        }
    }
}
