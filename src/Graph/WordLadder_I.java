package Graph;

import java.util.*;

public class WordLadder_I {

    static class pair{
        String first;
        int second;
        pair(String a , int b){
            this.first = a;
            this.second = b;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(beginWord,1));

        HashSet<String> set = new HashSet<>();
        int len = wordList.size();
        for(int i=0; i<len; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while(! q.isEmpty()){
            pair p = q.poll();
            String word = p.first;
            int step = p.second;

            if(word.equals(endWord) == true) return step;

            for(int j=0; j<word.length(); j++){
                for(char ch ='a'; ch <= 'z'; ch++){
                    char[] charArray = word.toCharArray();
                    charArray[j] = ch;
                    String newWord = new String(charArray);

                    if(set.contains(newWord) == true){
                        set.remove(newWord);
                        q.add(new pair(newWord , step+1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit","cog",list));
    }

}
