package Stack;

import java.util.Stack;

public class MaximalRectangle {

    public static void findNext( int[] ans ,int[] arr){
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        for(int i=n-1; i>=0; i--){
            while(stk.peek() != -1 && arr[stk.peek()] >= arr[i]) stk.pop();

            ans[i] = stk.peek();
            stk.push(i);

        }
    }

    public static void findPre( int[] ans ,int[] arr){
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        for(int i=0; i<n; i++){
            while(stk.peek() != -1 && arr[stk.peek()] >= arr[i]) stk.pop();

            ans[i] = stk.peek();
            stk.push(i);

        }
    }



    public static int find(int[]arr){
        int[] pre = new int[arr.length];
        int[] next = new int[arr.length];
        int ans =0;

        findPre(pre, arr);
        findNext(next, arr);

        for(int i=0; i<arr.length; i++){
            int l = arr[i];

            if(next[i] == -1) next[i] = arr.length;

            int b = next[i] - pre[i] - 1;
            int area = l*b;

            ans = Math.max(ans, area);
        }

        return ans;
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int []arr = new int[m];
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[j] = (matrix[i][j] == '1') ? arr[j]+1 : 0;
            }
            ans = Math.max(ans, find(arr));
        }
        return ans;
    }




    public static void main(String[] args) {

    }
}
