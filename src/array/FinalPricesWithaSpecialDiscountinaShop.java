package array;

import java.util.Stack;

public class FinalPricesWithaSpecialDiscountinaShop {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<prices.length; i++){

            while(!st.isEmpty() && prices[st.peek()] >= prices[i]){
                int ind = st.pop();
                prices[ind] -= prices[i];
            }
            st.push(i);
        }
        return prices;
    }


    public static void main(String[] args) {
        
    }
}
