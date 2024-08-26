package ATest;

import java.util.Arrays;

public class MergingPalindromes {

    public static String merging(String a, String b) {
        int[] countA = new int[26];
        int[] countB = new int[26];

        for (char ch : a.toCharArray()) {
            countA[ch - 'a']++;
        }

        for (char ch : b.toCharArray()) {
            countB[ch - 'a']++;
        }

        String mid = "";
        StringBuilder res = new StringBuilder();


        for (int i = 0; i < 26; i++) {
            char curr = (char) (i + 'a');

            if (countA[i] % 2 == 1 && countB[i] % 2 == 1 && mid.length() < 2) {
                mid = String.valueOf(curr) + curr;
            }

            if ((countA[i] % 2 == 1 || countB[i] % 2 == 1) && mid.isEmpty()) {
                mid = String.valueOf(curr);
            }

            int repeatCount = countA[i] / 2 + countB[i] / 2;
            for (int j = 0; j < repeatCount; j++) {
                res.append(curr);
            }
        }


        char[] resArray = res.toString().toCharArray();
        Arrays.sort(resArray);
        String sortedRes = new String(resArray);

        if (mid.length() == 2) {
            return sortedRes + mid.charAt(0) + new StringBuilder(sortedRes).reverse();
        }

        return sortedRes + mid + new StringBuilder(sortedRes).reverse();
    }




    public static void main(String[] args) {
        String a = "aab";
        String b = "cac";
        String result = merging(a, b);
        System.out.println(result);
    }
}
