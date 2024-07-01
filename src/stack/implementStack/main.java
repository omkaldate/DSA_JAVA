package stack.implementStack;

public class main {
    public static void main(String[] args)throws StackException {
//        customStack stk = new customStack(5);
//        stk.push(3);
//        stk.push(4);
//        stk.push(5);
//        stk.push(6);
//        stk.push(10);
//
//        System.out.println(stk.peek());
//        stk.push(40);


        dynamicStack dstk = new dynamicStack(2);
        dstk.push(3);
        dstk.push(4);
        dstk.push(5);
        dstk.push(6);
        dstk.push(10);
        System.out.println(dstk.peek());
    }
}
