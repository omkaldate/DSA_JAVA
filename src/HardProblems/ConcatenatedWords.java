package HardProblems;

import java.util.*;

public class ConcatenatedWords {

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();

        for (String word : words) {
            if (helper(word, s, memo)) {
                ans.add(word);
            }
        }
        return ans;
    }



    public static boolean helper(String word, Set<String> s, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefixWord = word.substring(0, i);
            String suffixWord = word.substring(i);

            if (s.contains(prefixWord) && (s.contains(suffixWord) ||  s.contains(prefixWord) && helper(suffixWord, s, memo))) {
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }


    public static void main(String[] args) {
        String []s = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(s));
    }
}
