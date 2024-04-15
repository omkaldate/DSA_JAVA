package bitMasking;

public class twoNotRepeatingElements {
    public static void main(String[] args){
        int[]arr = {1,2,1,2,3,4,5,5};
        int one = 0;
        int zero = 0;

        for(int i=0;i<arr.length;i++) {
            if ((arr[i] & 1) == 1) {
                one ^= arr[i];
            } else {
                zero ^= arr[i];
            }
        }
        System.out.println(zero);
        System.out.println(one);
    }
}
