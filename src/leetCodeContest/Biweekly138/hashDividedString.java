package leetCodeContest.Biweekly138;

public class hashDividedString {
    public static String stringHash(String s, int k) {

        int div = s.length()/k;
        StringBuilder ans = new StringBuilder();
        int i=0;

        while(i<s.length()){
            int val =0;

            for(int j=0; j<k; j++){
                val += s.charAt(j+i) - 'a';
            }
            i+=k;
            char hashedChar = (char) ('a' + (val % 26));
            ans.append(hashedChar);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s=  "abcd";
        int k = 2;
        System.out.println(stringHash(s,k));
    }
}
