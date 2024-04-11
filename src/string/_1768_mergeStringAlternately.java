package string;

public class _1768_mergeStringAlternately {
    public static void main(String[] args){
        System.out.println(mergeAlternately("aba" , "xyz"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int n1 = word2.length();
        int i=0,j=0,k=0;
        StringBuilder ans=new StringBuilder();

        while(i<n && j<n1){
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }
        while(i<n){
            ans.append(word1.charAt(i++));
        }
        while(j<n1){
            ans.append(word2.charAt(j++));
        }
        return ans.toString();
    }
}
