package REVISION.Rrcursion;

public class matrixPaths {

//    public static int path(int r,int c){
//        if(r==0 && c==0) {
//            return 1;
//        }
//        int cnt =0;
//        if(r>0){
//            cnt += path(r-1,c);
//        }
//        if(c>0){
//            cnt += path(r,c-1);
//        }
//        if(c>0 && r>0){
//            cnt += path(r-1,c-1);
//        }
//        return cnt;
//    }


//    public static int path(int r,int c,String s){
//            if(r==0 && c==0) {
//                System.out.println(s);
//                return 1;
//            }
//            int cnt =0;
//            if(r>0){
//                cnt += path(r-1,c,s+"D");
//            }
//            if(c>0){
//                cnt += path(r,c-1,s+"R");
//            }
//            return cnt;
//    }


    public static int path(int r,int c,String s){
        if(r==0 && c==0) {
            System.out.println(s);
            return 1;
        }
        int cnt =0;
        if(r>0){
            cnt += path(r-1,c,s+"D");
        }
        if(c>0){
            cnt += path(r,c-1,s+"R");
        }
        if(c>0 && r>0){
            cnt += path(r-1,c-1,s+"R");
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(path(2,2,""));
    }
}
