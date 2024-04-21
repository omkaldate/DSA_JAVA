package string;

public class countPrefixOfAGivenString {
    public static void main(String[] args){
        String[] words = {"a","b","c","ab","bc","abc"};
        String s = "abc";
        System.out.println(countPrefixes(words , s));

    }

    public static int countPrefixes(String[] words, String s) {
        int slen = s.length();
        int cnt = 0;

        for (int i=0; i < words.length; i++) {
            int wlen = words[i].length();
            if (slen >= wlen) {
                if (words[i].equals(s.substring(0, wlen))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
