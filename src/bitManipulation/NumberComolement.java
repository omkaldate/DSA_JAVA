package bitManipulation;

public class NumberComolement {
    public static int findComplement(int num) {
        if(num == 0) return 1;

        int bitLength = Integer.toBinaryString(num).length();
        int mask = (1 << bitLength) - 1;
        return mask - num;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(4));
    }
}
