package leetCodeContest.Biweekly128;

public class scoreofAString {
    public static void main(String[] args){
            String s = "hello";
            scoreOfString(s);
    }

    public static void scoreOfString(String s) {
        int sum =0;
        int i=0;

        while(i+1 < s.length()){
            int subtract =s.charAt(i) - s.charAt(i+1) ;
            sum += Math.abs(subtract);
            i++;
        }
        System.out.println(sum);

    }
}
