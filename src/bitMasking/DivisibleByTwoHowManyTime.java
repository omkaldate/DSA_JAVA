package bitMasking;

public class DivisibleByTwoHowManyTime {
    public static void main(String[] args){
        int n =8;
        int cnt =0;

        while(n>0){
            n>>=1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
