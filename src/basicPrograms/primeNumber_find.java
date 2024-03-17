package basicPrograms;

import java.util.ArrayList;
public class primeNumber_find {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        int n = 20;
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + isPrime(i));
            if (isPrime(i)) {
                list.add(i);
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}



