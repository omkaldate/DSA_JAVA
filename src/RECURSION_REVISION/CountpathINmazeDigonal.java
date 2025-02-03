package RECURSION_REVISION;

import java.util.ArrayList;

public class CountpathINmazeDigonal {
    public static void main(String[] args) {
        System.out.print(fun("",3,3));
    }

    public static ArrayList<String> fun(String str, int up, int left){
        ArrayList<String> list = new ArrayList<>();

        if(up == 1 && left == 1){
            list.add(str);
            return list;
        }
        if(up >1) {
            list.addAll(fun(str + "u", up - 1, left));
        }
        if(left >1){
            list.addAll(fun(str+"l", up,left-1));
        }
        if(up>1 && left>1){
            list.addAll(fun(str+"d",up-1,left-1));
        }

        return list;
    }
}
