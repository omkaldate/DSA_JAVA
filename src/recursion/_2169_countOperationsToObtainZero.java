package recursion;

public class _2169_countOperationsToObtainZero {
    public static void main(String[] args){
        System.out.println(funk(2,3,0));
    }

    static int funk(int num1 , int num2 , int count){
             if(num1 ==0 || num2 ==0){
                 return count;
             }
             if(num1>=num2){
                 return funk(num1-num2 , num2 , count+1);
             }
             else {
                 return funk(num1, num2 - num1, count + 1);
             }
    }
}
