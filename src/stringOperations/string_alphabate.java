package stringOperations;//public class stringOperations.string_alphabate {
//    public static void main(String[] args){
//        String series= " ";
//        for(int i=0; i<30; i++){
//            char ch =(char) ('a' +i);
//            series = series+ ch ;
//        }
//        System.out.println(series);
//    }
//}

//import java.util.Arrays;
//public class stringOperations.string_alphabate {
//    public static void main(String[] args) {
//      StringBuilder build = new StringBuilder();
//      String string = "";
//      for(int i=0; i< 26; i++){
//          char ch = (char)('a' + i);
//          string += ch;
//          build.append(ch);
//      }
//        System.out.println(build);
//
//      System.out.println(Arrays.toString(string.toCharArray()));
//    }
//}

import java.sql.SQLOutput;
import java.util.Arrays;
public class string_alphabate {
    public static void main(String[] args) {
      String name = "Om kaldate";
        System.out.println(name);
        System.out.println((name.toCharArray()));
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(name.indexOf('k'));
        System.out.println("          om kaldate         ".strip());
        System.out.println(Arrays.toString(name.split("d")));


    }
}