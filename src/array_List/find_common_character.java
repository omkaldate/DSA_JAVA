package array_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class find_common_character {
        public static  List<String> commonChars(String[] words) {
            int[] mincount=new int[26];
            Arrays.fill(mincount,Integer.MAX_VALUE);
            for(String str:words){
                int[] count=new int[26];
                for(char c:str.toCharArray()){
                    count[c-'a']+=1;
                }
                for(int i=0;i<26;i++){
                    mincount[i]=Math.min(mincount[i],count[i]);
                }
            }
            ArrayList<String> list=new ArrayList<>();
            for(int i=0;i<26;i++){
                for(int j=0;j<mincount[i];j++)
                    list.add(String.valueOf((char)('a'+i)));
            }
            return list;

        }

    public static void main(String[] args){
            String[] s= {"bella","label","roller"};
        System.out.println(commonChars(s));
    }
}
