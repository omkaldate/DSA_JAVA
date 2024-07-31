package string;

public class checkIfAllAappearingBeforeAllB {
    public static boolean checkString(String s) {

        boolean b = false;
        boolean first =true;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(first && ch =='b') b = true;
            if(ch == 'a' && b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaabba";
        System.out.println(checkString(s));
    }
}
