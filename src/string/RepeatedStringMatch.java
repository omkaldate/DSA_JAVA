package string;

public class RepeatedStringMatch {
    public static void LPS(String s, int[]arr){
        int pre =0;
        int suf =1;

        while(suf < s.length()){
            if(s.charAt(pre) == s.charAt(suf)){
                arr[suf] = pre+1;
                pre++;
                suf++;
            }
            else{
                if(pre == 0) suf++;
                else pre = arr[pre-1];
            }
        }
    }


    public static boolean KMP(String s, String comp, int[]arr){
        int fir =0;
        int sec =0;

        while(fir < s.length() && sec <comp.length()){
            if(s.charAt(fir) == comp.charAt(sec)){
                fir++;
                sec++;
            }
            else{
                if(sec == 0) fir++;
                else sec = arr[sec-1];
            }
        }
        return sec == comp.length();
    }


    public static int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;

        int x =1;
        String str = a;
        while(str.length() < b.length()){
            str+=a;
            x++;
        }

        int[]arr =new int[b.length()];
        LPS(b,arr);

        if(KMP(str,b,arr)) return x;
        if(KMP(str+a,b,arr)) return x+1;
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("ab","abababab"));
    }
}
