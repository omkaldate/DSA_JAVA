package REVISION.Rrcursion;

import java.util.ArrayList;

//public class PermutationString {
//    public static void permu(String up, String ps, ArrayList<String>list){
//        if(up.length() == 0){
//            list.add(ps);
//            return;
//        }
//        char ch = up.charAt(0);
//        for(int i=0; i<ps.length()+1; i++){
//            String f = ps.substring(0,i);
//            String l = ps.substring(i);
//            permu(up.substring(1),f+ch+l,list);
//        }
//    }

    public class PermutationString {
        public static int permu(String up, String ps){
            if(up.length() == 0){
                return 1;
            }
            int cnt =0;
            char ch = up.charAt(0);
            for(int i=0; i<ps.length()+1; i++){
                String f = ps.substring(0,i);
                String l = ps.substring(i);
               cnt+= permu(up.substring(1),f+ch+l);
            }
            return cnt;
        }


        public static void main(String[] args) {
        String str ="abc";
        ArrayList<String>lst = new ArrayList<>();

        System.out.println(permu(str,""));
    }
}
