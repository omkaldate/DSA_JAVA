package array;

public class oneBitAndTwoBitCharacters {
    public static boolean isOneBitCharacter(int[] bits) {
        boolean isPre = false;
        for (int i=0; i < bits.length-1; i++) {
            if (bits[i] == 0) {
                isPre = false;
            } else {
                isPre = !isPre;
            }
        }

        return !isPre;
    }

    public static void main(String[] args){
        int []arr = {0,1,0};
        System.out.println(isOneBitCharacter(arr));
    }
}
