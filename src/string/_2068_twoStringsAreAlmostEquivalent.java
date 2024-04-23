package string;

import java.util.HashMap;
import java.util.Map;

public class _2068_twoStringsAreAlmostEquivalent {
    public static void main(String[] args){
        System.out.println(checkAlmostEquivalent("cccddabba","babababab"));
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character,Integer> mpp1 = new HashMap<>();
        HashMap<Character,Integer>mpp2 = new HashMap<>();

        for(int i=0; i<word1.length(); i++){
            mpp1.put(word1.charAt(i),mpp1.getOrDefault(word1.charAt(i) , 0)+1);
        }
        for(int i=0; i<word2.length(); i++){
            mpp2.put(word2.charAt(i),mpp2.getOrDefault(word2.charAt(i) , 0)+1);
        }


//        for(Map.Entry<Character , Integer> i : mpp1.entrySet()){
//            System.out.println("mpp1 = " + i.getKey() + i.getValue());
//        }
//        for(Map.Entry<Character , Integer> j : mpp2.entrySet()){
//            System.out.println("mpp2 = " + j.getKey() + j.getValue());
//        }

        for(Map.Entry<Character,Integer> i : mpp1.entrySet()){
            if(mpp2.containsKey(i.getKey())){
                int cnt = Math.abs(i.getValue() - mpp2.get(i.getKey()));
                if(cnt > 3) return false;
            }
           else{
                int x = i.getValue();
                if(x > 3)return false;
           }
        }

        for(Map.Entry<Character , Integer> j : mpp2.entrySet()){
            if(!mpp1.containsKey(j.getKey())){
                int xx = j.getValue();
                if(xx > 3)return false;
            }
        }
        return true;

    }
}

