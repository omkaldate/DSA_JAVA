package TreeMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinimumNumbersOFPushesToTypeWord_II {

    public static int minimumPushes(String word) {
        if(word.length() == 0) return 0;

        HashMap<Character,Integer> mpp = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(char ch : word.toCharArray()){
            mpp.put(ch, mpp.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> x: mpp.entrySet()){
            list.add(x.getValue());
        }

        Collections.sort(list);
        System.out.println(list);

        int ans=0;
        int sum =0;
        int x=0;
        int i =1;

        while(! list.isEmpty()){
            sum += list.get(list.size()-1);
            list.remove(list.size()-1);
            x++;

            if(x == 8){
                x=0;
                ans += sum*i;
                sum=0;
                i++;
            }
        }

        if(x !=0){
            ans += sum*i;
        }

        return ans;
    }


    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(minimumPushes(s));
    }
}
