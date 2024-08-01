package string;

public class NumberOfSeniorCitizens {
    public static int countSeniors(String[] details) {
        int cnt =0;

        for(String i : details){
            if((((i.charAt(11) - '0') *10) + i.charAt(12) - '0') > 60 ) cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) {
        String[] str = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors(str));
    }
}
