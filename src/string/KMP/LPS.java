package string.KMP;

import java.util.Arrays;

public class LPS {

    public static void longestPS(String s , int[]arr){
        int pre =0;
        int suf =1;

        while(suf < arr.length){
            if(s.charAt(pre) == s.charAt(suf)){
                arr[suf] = pre+1;
                pre++;
                suf++;

            }
            else{
                if(pre == 0){
                    arr[suf] = 0;
                    suf++;
                }
                else{
                    pre = arr[pre-1];
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "abcabdabcabcabd";
        int[]arr = new int[s.length()];
        longestPS(s,arr);

        System.out.println(Arrays.toString(arr));
    }
}
