package string;

import java.util.Arrays;

public class PermutationInstring {

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] arr1 =new int[26];
        int[] arr2 =new int[26];

        if(l1 > l2) return false;

        for(int i = 0; i<l1; i++){
            arr1[s1.charAt(i) -'a']++;
            arr2[s2.charAt(i) -'a']++;
        }
        if(Arrays.equals(arr1, arr2))return true;

        for(int i=l1; i<l2; i++){
            arr2[s2.charAt(i) -'a']++;
            arr2[s2.charAt(i-l1) -'a']--;
            if(Arrays.equals(arr1, arr2)) return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
