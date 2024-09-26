package ATest;

import java.util.*;

public class VowelStringQuery {
    

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static int[] hasVowels(String[] strArr, String[] query) {
        int n = strArr.length;
        

        int[] isVowelFirstLast = new int[n];
        for (int i = 0; i < n; i++) {
            if (isVowel(strArr[i].charAt(0)) && isVowel(strArr[i].charAt(strArr[i].length() - 1))) {
                isVowelFirstLast[i] = 1;
            }
        }

        int[] vowelCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            vowelCount[i] = vowelCount[i - 1] + isVowelFirstLast[i - 1];
        }


        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] parts = query[i].split("-");
            int l = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);

            result[i] = vowelCount[r] - vowelCount[l - 1];
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] strArr = {"aab","a","bcd","awe","bbbbbu"};
        String[] query = {"2-3","4-5"};


        int[] results = hasVowels(strArr, query);


        System.out.println(Arrays.toString(results));
    }
}
