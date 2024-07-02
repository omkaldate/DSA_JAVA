package REVISION.Rrcursion;

import java.util.ArrayList;

public class Subsets {

    public static void subset(String ups,String ps,ArrayList<String>str){
        if(ups.length() == 0){
            str.add(ps);
            return;
        }
        char ch = ups.charAt(0);
        subset(ups.substring(1),ps+ch,str);
        subset(ups.substring(1),ps,str);
    }

    public static void main(String[] args) {
        ArrayList<String>st = new ArrayList<>();
        String str = "abc";

        subset(str,"",st);
        System.out.println(st);
    }
}
