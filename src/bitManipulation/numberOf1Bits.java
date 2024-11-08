package bitManipulation;

public class numberOf1Bits {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int cnt =0;
//         for(int i=0;i<32; i++){
//             if(((n>>i)&1) == 1){
//                 cnt++;
//             }
//         }
//         return cnt;


//        while(n > 0){
//            n = n&(n-1);
//            cnt++;
//        }
//        return cnt;


//        while(n != 0){
//            cnt += (n%2);
//            n=n/2;
//        }
//        return cnt;

        return Integer.bitCount(n);
    }
}
