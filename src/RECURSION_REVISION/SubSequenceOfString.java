package RECURSION_REVISION;

import java.util.ArrayList;

public class SubSequenceOfString {
    public static void main(String[] args) {

//        String s = "abc";
//        ArrayList<String> list = new ArrayList<>();
//        fun(s, list, "");
//        System.out.println(list);



        String s = "abc";
        System.out.println(functionA(s, ""));

    }

    public static void fun(String p, ArrayList<String>list, String up){
        if(p.length() == 0){
            list.add(up);
            return;
        }

        char ch = p.charAt(0);
        fun(p.substring(1),list,up+ch);
        fun(p.substring(1),list,up);
    }





    public static ArrayList<String> functionA(String p, String up){
        ArrayList<String>list = new ArrayList<>();
        if(p.length() == 0){
            list.add(up);
            return list;
        }

        char ch = p.charAt(0);
         list.addAll(functionA(p.substring(1),up+ch));
         list.addAll(functionA(p.substring(1),up));

         return list;
    }
}
