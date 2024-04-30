package bitMasking;

import java.util.HashMap;

public class numberOfWonderfullStrings {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(isitWonder(s));
    }

    public static long isitWonder(String word) {
        HashMap<Integer, Long> mpp = new HashMap<>();
        int value = 0, mask;
        long result = 0;
        mpp.put(0, (long) 1);

        for (int i = 0; i < word.length(); i++) {
            mask = 1 << ((int) (word.charAt(i) - 'a'));
            value ^= mask;
            result += mpp.getOrDefault(value, (long) 0);  // is it even

            for (char ch = 'a'; ch <= 'j'; ch++) {
                mask = 1 << ((int) (ch - 'a'));
                int oldValue = value ^ mask;
                result += mpp.getOrDefault(oldValue, (long) 0); //is it only one odd
            }

            mpp.put(value, mpp.getOrDefault(value, (long) 0) + 1);
        }
        return result;
    }
}
