package string;

import java.util.Arrays;

public class ReverseWordsinaString {
    public static void main(String[] args){
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] word = s.split("\\s+ ");
        // Split the string into words and trim leading/trailing spaces
        //s.trim() removes whitespaces from beginning and ending

        StringBuilder build = new StringBuilder();

        for (int i = 0; i<word.length/2; i++) {
            int j = word.length-i-1;
            String temp = word[i];
            word[i] = word[j];
            word[j] = temp;
        }

        for(String st : word){
            build.append(st);
            if(word[word.length-1] != st ){
                build.append(" ");
            }
        }
        return build.toString();

    }
}
