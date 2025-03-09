package slidingWindow;

public class MinimumRecolorstoGetKConsecutiveBlackBlocks {
    public static int minimumRecolors(String blocks, int k) {

        int maxi = 0;
        int i=0;
        int j=0;
        int ans = 0;

        while(j<blocks.length()){
            if(blocks.charAt(j) == 'B') ans++;

            if(j-i+1 == k){
                if(maxi < ans){
                    maxi = ans;
                }
                if(blocks.charAt(i) == 'B') ans--;
                i++;
            }

            j++;
        }
        return k-maxi;
    }


    public static void main(String[] args) {
        
    }
}
