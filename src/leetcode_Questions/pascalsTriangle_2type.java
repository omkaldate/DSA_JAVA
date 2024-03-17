package leetcode_Questions;

public class pascalsTriangle_2type {
    public static void main(String[] args){
        int n=6;
        int ans =1;
        System.out.println(ans);
        for(int i=1; i<n ; i++){
            ans = ans*(n-i);
            ans = ans /(i);
            System.out.println(ans);
        }
    }
}
