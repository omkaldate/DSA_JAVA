package recursion;

import java.util.ArrayList;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(4,17));
    }

    public static String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> number = new ArrayList<>();
        for(int i=1; i<n; i++){
            fact *= i;
            number.add(i);
        }
        number.add(n);

        String ans ="";
        k -= 1;

        System.out.println(number);
        System.out.println(fact);

        while(true){
            ans += number.get(k/fact);     // bcd list starts from 0 indexing
            number.remove(k/fact);

            if(number.size() == 0) break;

            k %= fact;
            fact /= number.size();
        }
        return ans;
    }
}
