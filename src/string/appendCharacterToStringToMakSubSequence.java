package string;

public class appendCharacterToStringToMakSubSequence {
    public static int appendCharacters(String s, String t) {
        int n = t.length();
        int i = 0, j = 0;
        int cnt = 0;
        int maxi = 0;

        while (i < s.length()) {
            if (j < n && s.charAt(i) == t.charAt(j)) {
                cnt++;
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        return n-cnt;
    }


    public static int hardapproachmy(String s, String t) {
         int n = t.length();
         int i = 0, j = 0;
         int cnt = 0;
         int maxi = 0;

         while (i < s.length()) {
             if (j < n && s.charAt(i) == t.charAt(j)) {
                 cnt++;
                 i++;
                 j++;
                 maxi = Math.max(maxi, cnt);
             }
             else if (j > 0) {
                 j = 0;
                 i++;
                 cnt = 0;
             }
              else {
                 i++;
             }
         }
         return n - maxi;
     }


    public static void main(String[] args){
        String s = "vrykt";    // for this taste case
        String t = "rkge" ;    // for this taste case
        System.out.println(appendCharacters(s,t));

        String q ="abcxyzabcd";
        String r = "abcd";
        System.out.println(hardapproachmy(q,r));
        System.out.println(appendCharacters(q,r));
    }
}
