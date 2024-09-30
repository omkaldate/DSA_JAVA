package leetCodeContest.Weely417;

public class findTheKThCharacterinStringGame_II {
    public static char kthCharacter(long k, int[] operations) {
        if(k == 1) return 'a';

        long len=1;
        long newK = -1;
        int opera = -1;

        for(int i=0; i<operations.length; i++){
            len *=2;

            if(len >= k){
                newK = k - len/2;
                opera = operations[i];
                break;
            }
        }

        char ch = kthCharacter(newK , operations);
        if(opera == 0) return ch;
        return ch == 'z' ? 'a' : (char) (ch+1);
    }

    public static void main(String[] args) {

    }
}
