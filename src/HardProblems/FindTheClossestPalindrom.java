package HardProblems;

public class FindTheClossestPalindrom {

    public static long isPalindrom(long firsthalf, boolean isEven){
        long result = firsthalf;

        if(isEven == false){
            firsthalf /=10;
        }
        while (firsthalf> 0){
            int digit =(int) firsthalf%10;
            result = (result * 10) + digit;
            firsthalf/=10;
        }
        return result;
    }

    public static String nearestPalindromic(String n) {
        int length = n.length();
        int mid = length/2;
        long firstlen= (length%2 == 0) ? mid: (mid+1);
        long firsthalf = Long.parseLong(n.substring(0,(int)(firstlen)));
        long[] arr = new long[5];

        arr[0] = isPalindrom(firsthalf, length%2 == 0);
        arr[1] = isPalindrom(firsthalf+1, length%2 == 0);
        arr[2] = isPalindrom(firsthalf-1, length%2 == 0);
        arr[3] = (long)Math.pow(10,length)+1;
        arr[4] =(long)Math.pow(10,length-1)-1;

        long diff = Long.MAX_VALUE;
        long result = Integer.MAX_VALUE;

        long value = Long.parseLong(n);

        for(long num: arr){
            if(num == value){
                continue;
            }
            if(Math.abs(num - value) < diff){
                diff = Math.abs(num - value);
                result = num;
            }
            else if(Math.abs(num - value) == diff){
                result= Math.min(result,num);
            }
        }
        return Long.toString(result);
    }

    public static void main(String[] args) {
        System.out.println(nearestPalindromic("123"));
    }
}
