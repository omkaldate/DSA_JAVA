package array;

public class ValidPerfectSquare {
    public static  boolean isPerfectSquare(int num) {
        long s =0;
        long e =num;

        while(s <= e){
            long m = s+ (e-s)/2;
            long val = m*m;

            if(val == num)return true;
            if(val < num){
                s = m+1;
            }
            else{
                e = m-1;
            }
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println(isPerfectSquare(6));
    }
}
