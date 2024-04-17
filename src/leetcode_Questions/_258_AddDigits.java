package leetcode_Questions;

public class _258_AddDigits {
    public static void main(String[]args){
        int num = 38;

        int sum=0;
        while(num%10 != num){
            while(num!= 0){
                sum += num %10;
                num = num/10;
            }
            num = sum;
            sum =0;
        }
        System.out.println(num);

    }
}
