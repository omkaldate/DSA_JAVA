package stack;

import java.util.Arrays;
import java.util.Stack;

public class largestRectangleArea {

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
        System.out.println("past = " + Arrays.toString(past));

        int[]future = new int[n];
         future = nextsmall(arr);
        System.out.println("future = " + Arrays.toString(future));

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


    public static void main(String[] args) {
        int arr[] ={2,1,5,6,2,3};
        System.out.println(largestRect(arr));
    }
}
