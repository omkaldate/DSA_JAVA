package string;

public class isSubsequence {
    public static void main(String[] args){
        String s ="abc";
        String t ="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {

        if(s.length() ==0) return true;
        int i=0;
        int j=0;

        while( j != t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                if(i == s.length())return true;
            }
            else{
                j++;
            }
        }
        return false;
    }
}
