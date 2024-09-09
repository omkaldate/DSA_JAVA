package Graph;

import java.util.*;

public class wordladder_II_optimal {
    static String beginWord;
    static HashMap<String, Integer> wordStepsMap;  // Stores the minimum steps required to reach each word
    static List<List<String>> ans;  // Stores all possible transformation sequences

    // DFS function to find all paths
    private static void dfs(String word, List<String> seq) {
        // If we reach the beginWord, reverse the sequence and store it
        if (word.equals(beginWord)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);  // Reverse the sequence
            ans.add(dup);  // Add to the answer list
            return;
        }

        int steps = wordStepsMap.get(word);
        int wordLength = word.length();

        // Try replacing each character in the word
        for (int i = 0; i < wordLength; i++) {
            char[] replacedCharArray = word.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);

                // Check if the replaced word is valid and follows the transformation step
                if (wordStepsMap.containsKey(replacedWord) && wordStepsMap.get(replacedWord) + 1 == steps) {
                    seq.add(replacedWord);  // Add this word to the current sequence
                    dfs(replacedWord, seq);  // Continue DFS
                    seq.remove(seq.size() - 1);  // Backtrack
                }
            }
        }
    }

    public static List<List<String>> findLadders(String beginWordParam, String endWord, List<String> wordList) {
        beginWord = beginWordParam;  // Corrected assignment
        wordStepsMap = new HashMap<>();
        ans = new ArrayList<>();

        Set<String> wordSet = new HashSet<>(wordList);  // Set to store all words
        if (!wordSet.contains(endWord)) {
            return ans;  // If endWord is not in the wordList, return empty result
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        wordStepsMap.put(beginWord, 1);  // Initialize step count for beginWord

        int wordLength = beginWord.length();
        wordSet.remove(beginWord);  // Remove beginWord from the set

        // BFS to find the shortest distance to each word
        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = wordStepsMap.get(word);

            // Stop BFS if we reach the endWord
            if (word.equals(endWord)) {
                break;
            }

            // Try changing each character of the word
            for (int i = 0; i < wordLength; i++) {
                char[] replacedCharArray = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // Check if the word is in the set and hasn't been visited
                    if (wordSet.contains(replacedWord)) {
                        q.add(replacedWord);  // Add new word to the queue
                        wordSet.remove(replacedWord);  // Mark as visited
                        wordStepsMap.put(replacedWord, steps + 1);  // Record the step count
                    }
                }
            }
        }

        // If the endWord has been reached, perform DFS to find all paths
        if (wordStepsMap.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        // Call the static method directly from the class
        List<List<String>> result = findLadders(beginWord, endWord, wordList);

        // Print the result
        System.out.println("All shortest transformation sequences:");
        for (List<String> sequence : result) {
            System.out.println(sequence);
        }
    }
}
