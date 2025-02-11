package string;

import java.util.Arrays;

public class RemoveAllOccurrencesofaSubstring {
    public static String removeOccurrences(String s, String part) {
        StringBuilder stack = new StringBuilder();
        int partLen = part.length();

        for(char c : s.toCharArray()){
            stack.append(c);

            if(stack.length() >= partLen && stack.substring(stack.length() - partLen).equals(part)){
                stack.setLength(stack.length() - partLen);
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {

    }
}
