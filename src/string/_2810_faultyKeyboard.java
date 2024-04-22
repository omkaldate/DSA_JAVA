package string;

public class _2810_faultyKeyboard {
    public static void main(String[] args){
        String s = "string";

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'i'){
                sb.reverse();
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
