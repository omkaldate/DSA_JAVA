package leetcode_Questions;

public class _70_climbingStairs {
    public static void main(String[] args){
            int n =5;
            System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if(n<=3){
            return n;
        }
        int a=3,b=2;
        for(int i=0; i<n-3; i++){
            a=a+b;
            b=a-b;
        }
        return a;
    }
}
