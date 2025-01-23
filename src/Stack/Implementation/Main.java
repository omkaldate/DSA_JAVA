package Stack.Implementation;

public class Main {

    public static void main(String[] args) throws stackException {

        CustomStack stk = new CustomStack();
        stk.push(1);
        stk.push(4);
        stk.push(5);

        System.out.println(stk.pop());
        System.out.println(stk.pop());

    }
}
