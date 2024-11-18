package slidingWindow;

public class DefuseBomb {
    public static int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if(k == 0) return ans;
        else if(k > 0) {
            for(int j = 1; j <= k; j++) {
                ans[0] += code[j];
            }
            for(int i = 1; i < code.length; i++) {
                ans[i] = ans[i-1] - code[i];
                ans[i] += code[(i+k)%code.length];
            }
            return ans;
        } else {
            for(int j = 1; j <= (k * -1); j++) {
                ans[code.length - 1] += code[code.length - 1 - j];
            }
            for(int i = code.length - 2; i >= 0; i--) {
                ans[i] = ans[i+1] - code[i];
                ans[i] += code[(i+k) >= 0 ? (i+k) : code.length + (i+k)];
            }
            return ans;
        }
    }


    
}
