package stack;

import java.util.ArrayList;
import java.util.Stack;

public class parsingAbooleanExpression {

    public static char fun(ArrayList<Character> list){
        char oper = list.get(list.size()-1);

        if(oper == '&'){
            for(int i=0; i<list.size()-1; i++){
                if(list.get(i) == 'f') return 'f';
            }
            return 't';
        }

        if(oper == '|'){
            int ans =0;
            for(int i=0; i<list.size()-1; i++){
                int val = (list.get(i) == 't') ? 1 : 0;
                ans |= val;
            }
            return (ans == 0) ? 'f' : 't';
        }

        else return (list.get(0) == 't') ? 'f' : 't';
    }


    public static boolean parseBoolExpr(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == ',' || ch =='(') continue;

            if(!stk.isEmpty() && ch == ')'){
                ArrayList<Character> list = new ArrayList<>();
                while(stk.peek()!='&' && stk.peek()!='|' && stk.peek()!='!'){
                    list.add(stk.pop());
                }
                char operator = stk.pop();
                list.add(operator);
                stk.push(fun(list));
            }
            else stk.push(ch);
        }
        return (stk.pop() == 't') ? true : false;
    }


    public static void main(String[] args) {

    }
}
