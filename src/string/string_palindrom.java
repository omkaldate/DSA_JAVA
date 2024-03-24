package string;

public class string_palindrom {
    public static void main(String[] args){
        String st = "asdffdsa";
        System.out.println(isPalindrom(st));
    }

    static boolean isPalindrom(String st){
        if(st.length()==0 ||  st ==null){
            return true;
        }
        for(int i=0 ; i<st.length() /2; i++){
            char start = st.charAt(i);
            char end = st.charAt(st.length() -i-1);

            if(start != end){
                return false;
            }
        }
        return true;
    }
}
