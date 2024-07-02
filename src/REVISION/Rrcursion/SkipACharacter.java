package REVISION.Rrcursion;

public class SkipACharacter {

    public static String skip(String str, String skipped,int index){
        if(index== str.length())return skipped;

        if(str.charAt(index) != 'a'){
            skipped += str.charAt(index);
        }
        return skip(str,skipped,index+1);
    }


    public static void main(String[] args) {
        String str = "aberbana";
        System.out.println(skip(str,"", 0));
    }
}
