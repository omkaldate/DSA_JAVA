package recursion_practice;

import java.sql.SQLOutput;

public class recursion_starpattern {
    public static void main(String[] args){

       // revertriangle(4, 0);
        triangle(3,0);
    }
    static void revertriangle(int r , int c){
        if(r==0){
            return;
        }
        if( r > c){
            System.out.print(" * ");
            revertriangle(r , c+1);
        }
        else {
            System.out.println();
            revertriangle(r-1 , 0);
        }

    }

    static void triangle(int r , int c){
        if(r==0){
            return;
        }
        if(r > c){
            triangle(r , c+1);
            System.out.print(" * ");
        }
        else{
            triangle(r-1 , 0);
            System.out.println( );
        }
    }
}
