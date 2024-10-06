package string;

public class SentenceSimilarityIII {

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] str1 = sentence1.split(" ");
        String[] str2 = sentence2.split(" ");
        if (sentence1.equals(sentence2)) return true;

        int s1s = 0;
        int s1e = str1.length - 1;
        int s2s = 0;
        int s2e = str2.length - 1;
        int com1 = 0;
        int com2 = 0;

        while (s1s <= s1e && s2s <= s2e && str1[s1s].equals(str2[s2s])) {
            s1s++;
            s2s++;
            com1++;
        }


        while (s1e >= s1s && s2e >= s2s && str1[s1e].equals(str2[s2e])) {
            s1e--;
            s2e--;
            com2++;
        }

        int min = Math.min(str1.length,str2.length);
        return com1+com2 == min;
    }



    public static void main(String[] args) {

    }
}
