package stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxRectangle {

    public static int[]prevsmall(int[]arr){
        int n = arr.length;
        int[]ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        for(int i=0; i<n; i++){
            int cur = arr[i];
            while(stk.peek() != -1 && arr[stk.peek()] >= cur){
                stk.pop();
            }
            ans[i] = stk.peek();
            stk.push(i);
        }
        return ans;

    }

    public static int[]nextsmall(int[]arr){
        int n = arr.length;
        int[]ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        for(int i=n-1; i>=0; i--){
            int cur = arr[i];
            while(stk.peek() != -1 && arr[stk.peek()] >= cur){
                stk.pop();
            }
            ans[i] = stk.peek();
            stk.push(i);
        }
        return ans;
    }

    public static int largestRect(int[]arr){
        int n = arr.length;

        int[]past = new int[n];
        past = prevsmall(arr);

        int[]future = new int[n];
        future = nextsmall(arr);

        int area = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int l = arr[i];

            if(future[i] == -1){
                future[i] = n;
            }
            int b = future[i]-past[i]-1;
            int newArea = l*b;
            area = Math.max(area,newArea);
        }
        return area;
    }

    public static int maxones(int[][]m ){
        int area = largestRect(m[0]);
        int x = m.length;
        int l = m[0].length;

        for(int i=1; i<x; i++){
            for(int j=0; j<l; j++){
                if(m[i][j] != 0) {
                    m[i][j] = m[i][j] + m[i-1][j];
                }
                else{
                    m[i][j] = 0;
                }
            }
            area = Math.max(area,largestRect(m[i]));
        }
        return area;
    }


    public static void main(String[] args) {
        int[][]m = {
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };
        System.out.println(maxones(m));
    }

}
