package string;

public class AddingSpaceToString {

    public static String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;

        StringBuilder result = new StringBuilder();
        int j = 0;

        for (int i = 0; i < m; i++) {
            if (j < n && i == spaces[j]) {
                result.append(" ");
                j++;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        
    }
}
