package slidingWindow;

public class GrumpyBookSroreOwner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int sum = 0;
        int maxsum = 0;
        int biggersum = 0;
        int i = 0, j = 0;
        boolean used = true;

        while (j < n) {
            if (j - i+1 == minutes){
                if (grumpy[j] == 1) {
                    maxsum += customers[j];
                    used = false;
                }
                biggersum = Math.max(biggersum, maxsum);
                if(grumpy[i] ==1 ){
                    maxsum -= customers[i] ;
                }
                i++;
            }
            if (grumpy[j] == 0) {
                sum += customers[j];
            }
            if (grumpy[j] == 1 && used == true) {
                maxsum += customers[j];
            }
            j++;
            used = true;
        }
        return sum + biggersum;
    }



    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[]grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers,grumpy,minutes));
    }
}
