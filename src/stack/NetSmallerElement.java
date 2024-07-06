package stack;

import java.util.Arrays;
import java.util.Stack;

public class NetSmallerElement {


    public static int[] nextSmall(int[]arr){
        int n = arr.length;
        int[]ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        for(int i=n-1; i>=0; i--){
            int cur = arr[i];
            while(stk.peek() >= cur){
                stk.pop();
            }
            ans[i] = stk.peek();
            stk.push(cur);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[]arr = {2,1,5,6,2,3};
        System.out.println(Arrays.toString(nextSmall(arr)));
    }
}
