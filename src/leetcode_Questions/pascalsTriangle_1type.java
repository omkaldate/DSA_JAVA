package leetcode_Questions;

public class pascalsTriangle_1type {
    public static void main(String[] args){

        int n = 5;
        int r =3;
        int val = NCR(n-1 , r-1);
        System.out.println(val);
    }

    public static int NCR(int n , int r){
        int res = 1;
        for(int i=0; i<r ; i++){
            res = res*(n-i);
            res = res /(i+1);
        }
        return res;
    }
}
