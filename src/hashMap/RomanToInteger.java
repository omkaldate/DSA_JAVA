package hashMap;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args){
        System.out.println(romanToInt("XVIII"));
    }

    public static int romanToInt(String s) {
        HashMap<Character,Integer> mpp = new HashMap<>();
        mpp.put('I' , 1);
        mpp.put('V' , 5);
        mpp.put('X' , 10);
        mpp.put('L' , 50);
        mpp.put('C' , 100);
        mpp.put('D' , 500);
        mpp.put('M' , 1000);

        int ans = 0;
        int prev = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            int sum = mpp.get(s.charAt(i));

            if(sum < prev) {
                ans = ans - sum;
            }
            else{
                ans = ans + sum;
            }

            prev = sum;
        }

        return ans;
    }
}
