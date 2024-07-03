package stack;
import java.util.Stack;

public class Validparenthesis {

    public static boolean isValid(String s){
    Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
        if(c == '(' || c == '{' || c == '[') {
            st.push(c);
        }
        else if(c == ')') {
            if(st.isEmpty() || st.pop() != '(')
                return false;
        }
        else if(c == '}') {
            if(st.isEmpty() || st.pop() != '{')
                return false;
        }
        else if(c == ']') {
            if(st.isEmpty() || st.pop() != '[')
                return false;
        }
    }
        return st.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("()}[]"));
    }



}
