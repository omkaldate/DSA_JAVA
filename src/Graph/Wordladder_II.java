package Graph;

import java.util.*;

public class Wordladder_II {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return res; // If endWord is not in wordList, return empty list
        }

        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.add(path);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;
        Set<String> wordsUsedThisLevel = new HashSet<>();

        while (!queue.isEmpty() && !found) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                List<String> currentPath = queue.poll();
                String lastWord = currentPath.get(currentPath.size() - 1);

                // Try changing each character of the last word
                for (int j = 0; j < lastWord.length(); j++) {
                    char[] wordChars = lastWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        char originalChar = wordChars[j];
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        if (newWord.equals(endWord)) {
                            List<String> newPath = new ArrayList<>(currentPath);
                            newPath.add(newWord);
                            res.add(newPath);
                            found = true;
                        }

                        if (!found && wordSet.contains(newWord) && !visited.contains(newWord)) {
                            List<String> newPath = new ArrayList<>(currentPath);
                            newPath.add(newWord);
                            queue.add(newPath);
                            wordsUsedThisLevel.add(newWord);
                        }

                        wordChars[j] = originalChar; // Backtrack to the original character
                    }
                }
            }

            // Mark all words used at this level as visited
            visited.addAll(wordsUsedThisLevel);
            wordsUsedThisLevel.clear();
        }

        return res;
    }


    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> result = findLadders(beginWord, endWord, wordList);

        for (List<String> sequence : result) {
            System.out.println(sequence);
        }
    }
}
