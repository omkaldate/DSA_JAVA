package string;

import java.util.HashSet;

public class minimizeStringLength {
    public static void main(String[] args){
        String st =  "aaabc";
        System.out.println(minimizedStringLength(st));
    }

    public static int minimizedStringLength(String s) {
        HashSet<Character> st = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            st.add(s.charAt(i));
        }
        return st.size();
    }
}
