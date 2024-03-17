package recursion_practice;

public class recursion_basicProgram {
    public static void main(String[] args) {

// *** understand the recursion function call
//        funk1(6);
//    }
//
//    static void funk1(int n){
//        if(n==0){
//            return ;
//        }
//        System.out.print(n);
//         funk1(n-1);
//        System.out.print(n);
//
//
//    }


// ***  finding factorial of given integer

//        System.out.println(factorial(4));
//    }
//
//    static int factorial(int n){
//            if(n==0){
//                return 1;
//            }
//
//            return n * factorial(n-1);v
//    }


 // *** total sum of given integer from
        System.out.println(sum(5));
    }

    static int sum(int n){
        if(n==0){
            return 0;
        }
        return n + sum(n-1);
    }
}
