package hashMap;

public class characterHashing {
    public static void main(String[] args) {
        String s = "abcdaf";
        int n = s.length();
        int []hash = new int[26];

        for(int i=0; i<n; i++){
            hash[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<5; i++) {
            System.out.println( hash[i]);
        }
    }
}
