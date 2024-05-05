package leetCodeContest.weekly396;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofperationstoMakeWordKPeriodic {
    public static void main(String[] args){
        String word =  "leetcodeleet";
        int k=4;
        System.out.println(minimumOperationsToMakeKPeriodic(word , k));
    }

    public static int minimumOperationsToMakeKPeriodic(String word, int k) {
        HashMap<String , Integer> map = new HashMap<>();

        int i = 0;

        while(i < word.length()) {
            String sub = word.substring(i, i + k);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            i = i + k;
        }

        int maxi = 0;
        int cnt = 0;
        for(Map.Entry<String, Integer> mp : map.entrySet()) {
            maxi = Math.max(mp.getValue(), maxi);
            cnt += mp.getValue();
        }

        return Math.abs(cnt - maxi);
    }
}
