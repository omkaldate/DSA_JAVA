package string;

public class circularSetense {
    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n; i++) {
            String word1 = words[i];
            String word2 = words[(i + 1) % n];
            if (word1.charAt(word1.length() - 1) != word2.charAt(0)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isCircularSentence("helllo"));
    }
}
