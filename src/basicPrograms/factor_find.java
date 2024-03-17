package basicPrograms;

public class factor_find {
    public static void main(String[] args){
        int n = 20;
       findFactor1(n);
       findFactor2(n);
    }

    static void findFactor1(int n){
        for(int i=2; i< n; i++){
            if(n%i ==0){
                System.out.println(i + " ");
            }
        }
    }

     static void findFactor2(int n){
        for(int i=1; i<Math.sqrt(n) ; i++){
            if(n%i == 0){
                if(n/i == i){
                    System.out.println(i + " ");
                }
                else{
                    System.out.println(i + " " + n/i + " ");
                }
            }
        }
     }
}
