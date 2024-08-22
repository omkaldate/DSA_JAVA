package HardProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords{

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int len = words[0].length();
        HashMap<String,Integer> mpp = new HashMap<>();

        for(String word : words){
            mpp.put(word, mpp.getOrDefault(word,0)+1);
        }

        for(int i=0; i<=s.length()-(words.length*len); i++){
            HashMap<String,Integer> mpp1 = new HashMap<>(mpp);

            for(int j=0; j<words.length; j++){
                String str = s.substring(i+j*len , i+j*len+len);

                if(mpp1.containsKey(str)){
                    int cnt = mpp1.get(str);
                    if(cnt == 1) mpp1.remove(str);
                    else mpp1.put(str,cnt-1);

                    if(mpp1.isEmpty()){
                        ans.add(i);
                    }
                }
                else break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] arr = {"word","good","best","good"};
        System.out.println(findSubstring(s,arr));
    }
}
