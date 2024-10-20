package recursion;

public class FindKthBitinNthBinaryString {

    public static char rec(int n, int k){
        if(n == 1) return '0';

        int val =( (int) Math.pow(2,n) ) -1;
        int mid = (val/2)+1;
        if(k == mid) return '1';
        if(k < mid) return rec(n-1,k);
        return rec(n-1, (val-k)+1) == '0'? '1' : '0';
    }


    public static char findKthBit(int n, int k) {
        return rec(n,k);
    }


    public static void main(String[] args) {

    }
}
