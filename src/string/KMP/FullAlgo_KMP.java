package string.KMP;

public class FullAlgo_KMP {
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

    public static int KMP(String s1 , String s2){
        int[]lps = new int[s2.length()];
        longestPS(s2,lps);
        int fir =0;
        int sec =0;

        while(fir < s1.length() && sec < s2.length()){
            if(s1.charAt(fir) == s2.charAt(sec)){
                fir++;
                sec++;
            }
            else{
                if(sec == 0){
                    fir++;
                }
                else{
                    sec = lps[sec-1];
                }
            }
        }
        if(sec == s2.length()){
            return fir-sec;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "abcdaabceaabceaabdop";
        String s2 = "aabceaabdo";

        System.out.println(KMP(s1,s2));
    }
}
