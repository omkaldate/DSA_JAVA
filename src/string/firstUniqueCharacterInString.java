package string;

public class firstUniqueCharacterInString {
    public static void main(String[] args){
        String s ="eeetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {

        if(s.length()==1) return 0;
        int freq[] = new int[26];
        char t[] = s.toCharArray();

        for(char i:t){
            freq[i-'a']++;
        }
        for(char i:t){
            if(freq[i-'a']==1) return s.indexOf(i);
        }
        return -1;
    }
}
