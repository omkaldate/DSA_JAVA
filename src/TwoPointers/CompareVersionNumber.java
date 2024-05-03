package TwoPointers;

public class CompareVersionNumber {
    public static void main(String[] args){
String s1 = "1.01";
String s2 = "1.001";
        System.out.println(compareVersion(s1 , s2));
    }

    public static  int compareVersion(String version1, String version2) {
        int ptr1 = 0, ptr2 = 0;
        int num1 = 0, num2 = 0;
        int len1 = version1.length(), len2 = version2.length();

        while (ptr1 < len1 || ptr2 < len2) {
            while (ptr1 < len1 && version1.charAt(ptr1) != '.') {
                num1 = num1 * 10 + (version1.charAt(ptr1) - '0');
                ptr1++;
            }
            while (ptr2 < len2 && version2.charAt(ptr2) != '.') {
                num2 = num2 * 10 + (version2.charAt(ptr2) - '0');
                ptr2++;
            }
            System.out.println(num1 + " " + num2);

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;

            ptr1++;
            ptr2++;
            num1 = 0;
            num2 = 0;
        }

        return 0;
    }
}
