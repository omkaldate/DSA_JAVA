package stack;

import java.util.Stack;

public class CelebrityProblem {

    public static boolean knows(int[][]m, int a ,int b, int n){
        if(m[a][b] == 1){
            return true;
        }
        else{
            return false;
        }
    }


    public static int celebrity(int[][]m , int n){
        Stack<Integer>stk = new Stack<>();

        for(int i=0; i<n; i++){
            stk.push(i);
        }
        while(stk.size() > 1){
            int a = stk.pop();
            int b = stk.pop();

            if(knows(m,a,b,n)){
                stk.push(b);
            }
            else{
                stk.push(a);
            }
        }
        int ans = stk.peek();

        int zeroCount = 0;
        for(int i=0; i<n; i++){
            if(m[ans][i] == 0) {
                zeroCount++;
            }
        }
        if(zeroCount != n){
            return -1;
        }
        int oneCount = 0;
        for(int i=0; i<n; i++){
            if(m[i][ans] == 1) {
                oneCount++;
            }
        }
        if(oneCount != n-1){
            return -1;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][]m = {
                {0,1,0},
                {0,0,0},
                {0,1,0}
        };
        System.out.println(celebrity(m,3));

    }
}
