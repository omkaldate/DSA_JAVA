package stack;
import java.util.Stack;

public class SpecialStack {
    Stack<Integer> stk;
    int mini;

    SpecialStack(){
        stk = new Stack<>();
        mini = Integer.MAX_VALUE;
    }

    public void push(int data){
        if(stk.isEmpty()){
            stk.push(data);
            mini = data;
        }
        else{
            if(data < mini){
                stk.push(2 * data - mini);
                mini = data;
            }
            else{
                stk.push(data);
            }
        }
    }
    public int pop(){
        if(stk.isEmpty()) return -1;

        int curr = stk.pop();
        if(curr > mini) return curr;
        else{
            int precMini = mini;
            int val = 2 * mini - curr;
            mini = val;
            return precMini;
        }
    }
    public int peek(){
        if(stk.isEmpty())return -1;
        int curr = stk.peek();

        if(curr < mini){
            return mini;
        }
        else{
            return curr;
        }
    }
    public int getMini(){
        if(stk.isEmpty()) return -1;
        else{
            return mini;
        }
    }


    public static void main(String[] args) {
        SpecialStack stk = new SpecialStack();
        stk.push(5);
        stk.push(3);
        stk.push(8);
        stk.push(2);
        stk.push(4);

        System.out.println(stk.getMini());
        System.out.println(stk.pop());
        System.out.println(stk.getMini());
        System.out.println(stk.pop());
        System.out.println(stk.getMini());
        System.out.println(stk.pop());
        System.out.println(stk.peek());
    }
}
