package stack;

import java.util.Stack;

public class baseBallGame {
    public static  int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();

        for(String i : operations){
            if(i.equals("+")){
                int prev = stk.pop();
                int sum = stk.peek()+prev;
                stk.push(prev);
                stk.push(sum);
            }
            else if(i.equals("D")){
                stk.push(stk.peek()*2);
            }
            else if(i.equals("C")){
                stk.pop();
            }
            else{
                stk.push(Integer.parseInt(i));
            }
        }
        int sum =0;
        while(!stk.isEmpty()){
            sum += stk.pop();
        }
        return sum;
    }


    public static void main(String[] args) {
        String[]str = {"5","2","C","D","+"};
        System.out.println(calPoints(str));
    }
}
