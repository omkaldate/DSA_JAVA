package leetCodeContest.weekly396;

public class validWord {
    public static void main(String[] args){
        String word =  "234Adas";
        System.out.println(isValid(word));
    }

    public static boolean isValid(String word) {
        int vowel =0;
        int num =0;
        int constr =0;

        if(word.length() < 3) return false;

        for(int i=0; i<word.length(); i++){
            char ch =word.charAt(i);

            if(ch== 'a' || ch== 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                vowel ++;
            }

            else if(ch=='0' || ch=='1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch =='9'){
                num++;
            }

            else if (ch == '@' || ch == '#' || ch == '$') {
                return false;
            }

            else {
                constr ++;
            }
        }

        if(vowel >= 1 && constr >= 1) return true;
        else return false;
    }
}
