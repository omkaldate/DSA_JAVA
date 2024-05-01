package string;

public class reversePrefixWord {
    public static void main(String[]args){
        String word = "abcdefd";
        System.out.println(reversePrefix(word , 'd'));
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder st = new StringBuilder();;
        int end =-1;

        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == ch){
                end =i;
                st.append((word.substring(0 , i+1)));
                st.reverse();
                break;
            }
        }
        st.append( word.substring(end+1 , word.length()));
        return st.toString();
    }
}
