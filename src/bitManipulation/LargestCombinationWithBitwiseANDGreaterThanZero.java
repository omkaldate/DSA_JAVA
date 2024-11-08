package bitManipulation;

public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public static int largestCombination(int[] candidates) {
        int ans = 1;
        for(int i=0; i<32; i++){
            int c=0;
            for(int x: candidates){
                if((x&(1<<i))>0) c++;
            }
            ans = Math.max(ans, c);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
