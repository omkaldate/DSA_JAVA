package leetCodeContest.Weekly394;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CounttheNumberofSpecialCharacters_II {
    public static void main(String[] args){
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }

    public static int numberOfSpecialChars(String word) {
        int n = word.length();
        HashMap<Character, List<Integer>> map = new HashMap<>();

        // traverse on lowercase and store in hashmap
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                if (map.containsKey(ch)) {
                    map.get(ch).add(i);
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(ch, list);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (Character.isUpperCase(ch)) {
                char lowerCaseLetter = Character.toLowerCase(ch);
                if (map.containsKey(lowerCaseLetter)) {
                    List<Integer> list = map.get(lowerCaseLetter);
                    int lastIndex = list.get(list.size() - 1);

                    if (lastIndex > i) {
                        map.remove(lowerCaseLetter);
                    }
                    else {
                        for (int it : list){
                            if (it < i) {
                                ans++;
                                map.remove(lowerCaseLetter);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
