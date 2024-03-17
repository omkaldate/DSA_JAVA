package array_List;
import java.util.*;
public class _66_plusOne {
    public static void main(String[] args){
 ArrayList<Integer> list = new ArrayList<>();
 for(int i=1; i<5; i++){
     list.add(i);
 }
  System.out.println(addOneToNumber(list));

    }

    public static ArrayList<Integer> addOneToNumber(ArrayList<Integer> digits)
    {
        for (int i = digits.size()-1; i>=0; i--) {
            if (digits.get(i) < 9) {
                digits.set( i , digits.get(i)+1);
                return digits;
            }
            digits.set(i,0);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int j = 1; j < digits.size()+1; j++) {
            arr.set(j, digits.get(j-1));
        }
        arr.set(0 , 1);
        return arr;
    }

}


