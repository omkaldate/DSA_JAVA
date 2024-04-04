package recursion;

import java.util.ArrayList;

public class backTracking {
    public static void main(String[] args){
       // System.out.println(count(3,3));
       // path("" , 3,3);
       // System.out.println(path("" , 3,3));
        System.out.println(digonal("" , 3 , 3));

    }


    // count the number of paths
//    static int count(int r , int c){
//        if(r==1 || c==1){
//            return 1;
//        }
//        int left = count(r-1 , c);
//        int right= count(r,c-1);
//
//        return left+right;
//    }


    // find that paths
//    static void path( String p ,int r , int c){
//        if(r==1 && c==1){
//            System.out.println(p);
//            return ;
//        }
//       if(r>1){
//           path(p+'d' , r-1 , c);
//       }
//        if(c>1){
//            path(p+'r' , r , c-1);
//        }
//    }


    // find path using arrayList
//    static ArrayList<String> path( String p ,int r , int c){
//        if(r==1 && c==1){
//           ArrayList<String>list = new ArrayList<>();
//           list.add(p);
//            return list;
//        }
//        ArrayList<String> allcomb = new ArrayList<>();
//        if(r>1){
//           allcomb.addAll(path(p+'d' , r-1 , c));
//        }
//        if(c>1){
//           allcomb.addAll(path(p+'r' , r , c-1));
//        }
//        return allcomb;
//    }

    // digonal path (3 - paths)
        static ArrayList<String> digonal( String p ,int r , int c){
        if(r==1 && c==1){
           ArrayList<String>list = new ArrayList<>();
           list.add(p);
            return list;
        }
        ArrayList<String> allcomb = new ArrayList<>();
        if(r>1 && c>1){
            allcomb.addAll(digonal(p+'d' , r-1 , c-1));
        }
        if(r>1){
           allcomb.addAll(digonal(p+'v' , r-1 , c));
        }
        if(c>1){
           allcomb.addAll(digonal(p+'h' , r , c-1));
        }
        return allcomb;
    }
}
