package string;

public class countingWordsWithGivenPrefix {
    public static void main(String[] args){
    String[] words = {"pay","attention","practice","attend"};
    String pref = "at";
        System.out.println(prefixCount(words , pref));
    }


    public static int prefixCount(String[] words, String pref) {
        int len = pref.length();
        int cnt=0;

        for(int i=0; i<words.length; i++){
            if(words[i].length() >= len){
                String cmp = words[i].substring(0,len);
                if(pref.equals(cmp)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
