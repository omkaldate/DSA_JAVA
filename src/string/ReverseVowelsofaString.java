package string;

import java.util.Arrays;

public class ReverseVowelsofaString {
    public static void main(String[] args){
        String s = "hello";
        char arr[] = s.toCharArray();
        int l = 0;
        int h = arr.length - 1;
        StringBuilder sb = new StringBuilder();

        while (l < h) {
            if (isVowel(arr[l]) && isVowel(arr[h])) {
                char temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
                l++;
                h--;
            } else if (isVowel(arr[l]) && !isVowel(arr[h])) {
                h--;
            } else {
                l++;
            }
        }
        sb.append(arr);
        System.out.println(sb.toString());
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')return true;
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')return true;

        return false;
    }
}
