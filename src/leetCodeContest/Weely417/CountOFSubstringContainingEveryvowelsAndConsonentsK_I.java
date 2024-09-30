package leetCodeContest.Weely417;

import java.util.HashSet;

public class CountOFSubstringContainingEveryvowelsAndConsonentsK_I {
    public static void callSet(HashSet<Character> track){
        track.add('a');
        track.add('e');
        track.add('i');
        track.add('o');
        track.add('u');
    }

    public static int countOfSubstrings(String word, int k) {
        int n = word.length();

        HashSet<Character> track = new HashSet<>();
        String vowels = "aeiou";
        int ans =0;

        for(int i=0; i<n; i++){
            callSet(track);
            int conso = 0;

            for(int j=i; j<n; j++){
                if(vowels.contains(""+word.charAt(j))){
                    track.remove(word.charAt(j));
                }
                else conso++;

                if(track.isEmpty() && conso==k) ans++;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aeioqu",1));
    }

}
