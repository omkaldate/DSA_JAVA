package RECURSION_REVISION;

import java.util.ArrayList;

public class PermutationInString {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(fun(s,""));
    }

    public static ArrayList<String> fun(String p, String up){
        ArrayList<String> list = new ArrayList<>();

        if(p.length() == 0){
            list.add(up);
            return list;
        }

        for(int i=0; i<up.length()+1; i++){
            String one = up.substring(0,i);
            String two = up.substring(i,up.length());
            char ch = p.charAt(0);
            list.addAll(fun(p.substring(1),one+ch+two));
        }
        return list;
    }
}
