package recursion;

public class stream_2 {
    public static void main(String[] args){
        //   skip("" , "baccad");
        System.out.println(skipApple("bdappleyz"));
    }
    

    public static String skipApple( String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipApple(up.substring(5)) ;
        }
        else{
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }
}
