package Maths;

public class FindThestudentThatWillReplaceTheChunk {
    public static int chalkReplacer(int[] chalk, int k) {

        long sum =0;
        for(int i=0; i<chalk.length; i++){
            if(chalk[i] >0){
                sum += chalk[i];
            }
        }

        long rem = k % sum;
        System.out.println(sum +" "+rem);

        for(int i=0; i<chalk.length; i++){
            if(rem - chalk[i] >=0){
                rem = rem-chalk[i];
            }
            else return i;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[]arr = {3,4,1,2};
        int k = 25;

        System.out.println(chalkReplacer(arr,k));
    }
}
