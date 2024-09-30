package leetCodeContest.Weely417;

public class FindkthCharacterInStringGrame_I {
    public static char kthCharacter(int k) {
        if(k == 0) return 'a';

        String s = "a";

        while (s.length() < k) {
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char nextChar = s.charAt(i) == 'z' ? 'a' : (char)(s.charAt(i) + 1);
                str.append(nextChar);

                if (s.length() + str.length() == k) {
                    return nextChar;
                }
            }

            s += str.toString();
        }

        return 'a';
    }


    public static void main(String[] args) {

    }
}
