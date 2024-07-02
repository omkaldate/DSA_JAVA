package REVISION.Rrcursion;

public class StarPrint {

    public static void printStar(int r, int c) {
       if(r==0)return;

       if(r>c){
           System.out.print("* ");
           printStar(r,++c);
       }
       else{
           System.out.println();
           printStar(--r,0);
       }
    }

    public static void main(String[] args) {
        printStar(100,0);
    }

}
