package array;

public class SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        long i=0;
        long j= (int)Math.sqrt(c);
        if(c == 0) return true;

        while(i <= j){
            long val = (i*i) + (j*j);

            if(val == c) return true;

            if(val < c){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println(judgeSquareSum(4));
    }
}
