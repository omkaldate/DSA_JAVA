package leetcode_Questions;

public class _2485_findThePivotInteger_Addition {
    public static void main(String[] args){
        int n =8;
        System.out.println(pivotInteger(n));
    }
    public static int pivotInteger(int n) {

        int i=0;
        int j=n;
        int s1=i , s2=j;

        while(i <= j){
            if(s1 == s2 && i==j){
                return i;
            }
            else if(s1 == s2 && i<j){
                s1 += ++i;
            }
            else if(s1 < s2){
                s1 += ++i;
            }
            else{
                s2 += --j;
            }
        }
        return -1;
    }

}
