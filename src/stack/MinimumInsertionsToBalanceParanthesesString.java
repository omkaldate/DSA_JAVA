package stack;

import java.util.Stack;

public class MinimumInsertionsToBalanceParanthesesString {

    public static int minInsertions(String s) {
        int n =s.length();
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                stack.add(s.charAt(i));
            }
            else if(i+1<n && s.charAt(i) == ')' && s.charAt(i+1) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else {
                    ans++;
                }
                i++;
            }
            else if(i+1<n && s.charAt(i) == ')' && s.charAt(i+1) != ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                    ans++;
                }
                else {
                    ans=ans+2;
                }
            }
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                    ans++;
                }
                else {
                    ans=ans+2;
                }
            }
        }
        return ans +stack.size()*2;
    }


    public static void main(String[] args) {
        System.out.println(minInsertions("()))("));
    }
}
