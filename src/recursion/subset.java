package recursion;

import java.util.ArrayList;

public class subset {
    public static void main(String[] args){
      //  subseq("" , "abc");
        System.out.println(subseq1("", "abc"));

    }

//    public static void subseq(String p , String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        char ch = up.charAt(0);
//        subseq(p+ch , up.substring(1));
//        subseq(p , up.substring(1));
//
//    }

    public static ArrayList<String> subseq1(String p , String up){
        if(up.isEmpty()){
          ArrayList<String> list = new ArrayList<>();
          list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseq1(p+ch , up.substring(1));
        ArrayList<String> right = subseq1(p , up.substring(1));

        left.addAll(right);
        return left;
    }
}
