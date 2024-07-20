package leetCodeContest.Biweekly135;

public class FindtheWinningPlayerinCoinGame {

    public static String losingPlayer(int x, int y) {
        int divVal = y / 4;
        if(divVal == 0) return "Bob";

        if(divVal != 0 && x >= divVal) {
            if(divVal % 2 == 0) return "Bob";
            else return "Alice";
        }
        else {
            if(x % 2 == 1) return "Alice";
            else return "Bob";
        }
    }



    public static void main(String[] args) {
        System.out.println(losingPlayer(2,7));
    }
}
