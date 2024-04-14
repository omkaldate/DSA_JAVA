package bitMasking;

public class reverseBits {
    public static void main(String[] args){int n =0000000011;

        int result =0;
        for(int i=0; i<32; i++){
            result<<=1;
            if((n&1) > 0) result++;
                n>>=1;
            }
        System.out.println(result);

        //return Integer.reverse(n);
    }
}
