package Stack;

import java.util.Stack;

public class TheCelebrityproblem {
    public static int celebrity(int mat[][]) {
        Stack<Integer> stk = new Stack<>();

        int n = mat.length;

        for(int i=0; i<n; i++) stk.push(i);


        while(stk.size() > 1){
            int a = stk.pop();
            int b = stk.pop();

            if(mat[a][b] == 1) stk.push(b);
            else stk.push(a);
        }

        for(int i=0; i<mat[0].length; i++){
            if(mat[stk.peek()][i] != 0) return -1;
        }

        for(int i=0; i<n; i++){
            if(i!=stk.peek() && mat[i][stk.peek()] !=1 ) return -1;
        }

        return stk.peek();
    }


    public static void main(String[] args) {

    }
}
