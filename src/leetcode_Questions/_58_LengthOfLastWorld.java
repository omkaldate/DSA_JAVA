package leetcode_Questions;

public class _58_LengthOfLastWorld {
    public static void main(String[] args){
        String s = " om ram shankar  ram  ";
        System.out.println(lengthOfLastWord(s));
    }


    public static int lengthOfLastWord(String s) {

        String str = s.trim();
        System.out.println(str);
        int cnt =0;

        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) != ' '){
                cnt++;
            }
            else {
                break;
            }
        }
        return cnt;
    }
}
