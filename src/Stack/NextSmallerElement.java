package Stack;

import java.util.Stack;

public class NextSmallerElement {
    public void immediateSmaller(int arr[]) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        for(int i=arr.length-1; i>=0; i--){
            while(stk.peek() > arr[i]){
                stk.pop();
            }
            int val = arr[i];
            arr[i] = stk.peek();
            stk.push(val);

        }
    }


    public static void main(String[] args) {

    }
}
