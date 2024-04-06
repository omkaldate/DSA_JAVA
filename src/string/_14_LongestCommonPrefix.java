package string;

import java.util.Arrays;

public class _14_LongestCommonPrefix {
    public static void main(String[] args){
        String [] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1= strs[0];
        String str2=strs[strs.length-1];
        int i=0;
        while(i<str1.length()) {
            if(str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            i++;
        }
        return str1.substring(0, i);
    }
}

