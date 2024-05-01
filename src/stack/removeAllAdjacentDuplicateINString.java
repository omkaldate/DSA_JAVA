package stack;

import java.util.Stack;

public class removeAllAdjacentDuplicateINString {
    public static void main(String[] args){
        String st ="abbaca";
        System.out.println(removeDuplicates( st));
    }

    public static String removeDuplicates(String s) {
            Stack<Character> st = new Stack();
            for(int i=0; i<s.length(); i++){
                if(!st.isEmpty() && (st.peek() == s.charAt(i))){
                st.pop();
                }
                else{
                    st.push(s.charAt(i));
                }
            }

            StringBuilder str = new StringBuilder();
            while(st.size() != 0){
                str.append(st.pop());
            }
            return str.reverse().toString();
    }
}
