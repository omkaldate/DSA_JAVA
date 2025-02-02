package RECURSION_REVISION;

public class SkipACharacterInString {
    public static void main(String[] args) {
        String s = "jangoa";
        System.out.println(fun(s, ""));
    }

    public static String fun(String p, String u){
        if(p.length() == 0) return u;

        if(p.charAt(0) == 'a') return fun(p.substring(1),u);
        else{
            u += p.charAt(0);
            return fun(p.substring(1),u);
        }
    }
}
