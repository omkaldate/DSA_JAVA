package REVISION.Rrcursion;

public class NumberOfStemp {

    public static int steps(int num , int cnt){
        if(num == 0) return cnt;

        if(num%2 == 0) return steps(num/2,cnt+1);
        return steps(num-1,cnt+1);
    }


    public static void main(String[] args) {
        System.out.println(steps(14,0));
    }
}
