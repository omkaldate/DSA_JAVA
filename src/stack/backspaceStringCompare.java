package stack;

import java.util.Stack;

public class backspaceStringCompare {
    public static void main(String[] args){
        String s1 = "a#b#cd";
        String s2 = "btc###cd";
        System.out.println(isEqual(s1 , s2));

    }

    public static boolean isEqual(String s , String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                s1.push(s.charAt(i));
            } else if (!s1.isEmpty()) {
                s1.pop();
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                s2.push(t.charAt(i));
            } else if (!s2.isEmpty()) {
                s2.pop();
            }
        }

        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }
}
