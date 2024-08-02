package array;

public class TimeNeededToRearrangeBinaryString {
    public static int secondsToRemoveOccurrences(String s) {
        int zeroes=0, sec=0;
        for(int i=0; i<s.length(); i++){
            zeroes+= s.charAt(i)=='0' ? 1 : 0;
            if(s.charAt(i)=='1' && zeroes>0){
                sec = Math.max(sec+1, zeroes);
            }
        }
        return sec;
    }


    public static void main(String[] args) {
        String s = "0110101";
        System.out.println(secondsToRemoveOccurrences(s));
    }
}
