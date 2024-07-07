package array;

public class WatterBottle {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while(numBottles >= numExchange){
            ans += numBottles/numExchange;
            numBottles = (numBottles/numExchange)+(numBottles%numExchange);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15,4));
    }
}
