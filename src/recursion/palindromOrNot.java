package recursion;

import java.util.Arrays;

public class palindromOrNot {
    public static void main(String[] args){
        String str= "akbsbka";
        System.out.println(isPalindrom(str,0));
    }
    static Boolean isPalindrom(String str,int i){
        if(i > str.length()/2){
            return true;
        }
        return str.charAt(i) == str.charAt(str.length()-i-1) && isPalindrom(str , i+1);
    }

}
