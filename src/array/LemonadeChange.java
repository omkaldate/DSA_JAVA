package array;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int cntFi = 0;
        int cntTn =0;

        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5) cntFi++;

            if(bills[i] == 10){
                if(cntFi > 0){
                    cntFi--;
                    cntTn++;
                }
                else return false;
            }

            else if(bills[i] == 20){
                if(cntTn > 0 && cntFi>0){
                    cntTn--;
                    cntFi--;
                }
                else if(cntFi>=3){
                    cntFi = cntFi-3;
                }
                else return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        int []arr = {5,5,5,10,20};
        System.out.println(lemonadeChange(arr));
    }
}
