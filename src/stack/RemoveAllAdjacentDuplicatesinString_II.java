package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinString_II {
    public static void main(String[] args){
        String s = "deeedbbcccbdaa";
        System.out.println(removeDuplicates(s , 3));
    }


    public static String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(!st.isEmpty() && st.peek() == ch) {
                st.push(ch);
                isCorrect(st, k, ch);
            }
            else {
                st.push(ch);
            }
        }
        StringBuilder build = new StringBuilder();
        while(!st.isEmpty()){
            build.append(st.pop());
        }
        return build.reverse().toString();
    }


    public static void isCorrect(Stack<Character>st , int k, char ch){
       Stack<Character> temp = new Stack<>();

       while(!st.isEmpty() && st.peek() == ch) {
           temp.push(st.pop());
       }

       if(temp.size() != k) {
           while(!temp.isEmpty()) {
               st.push(temp.pop());
           }
       }
    }
}
