package oopsCollage_practicals;

import java.util.ArrayList;

public class first_50_PrimeNumber {

    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args){
        first_50_PrimeNumber obj = new first_50_PrimeNumber();
        obj.funk();
    }

    public void funk(){
        int c=0;
        while(list.size()<=50){
           isPrime(c);
            c++;
        }
        System.out.println("the first 50 prime numbers are = "+ list);
    }

    public  void isPrime(int n){

       if(n<= 1){
           System.out.println(n+ " is not prime number");     // comment
           return;
       }
         int truu =1;
         for(int i=2; i<=n/2; i++){
             if(n%i ==0){
                 System.out.println(n+ " is not prime number");   // comment
                 truu = 0;
                 break;
             }
         }
         if(truu ==1) {
             System.out.println(n + " is prime number");  // comment
             list.add(n);
         }
    }
}
